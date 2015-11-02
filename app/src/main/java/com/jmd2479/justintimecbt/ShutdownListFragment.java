package com.jmd2479.justintimecbt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by Jonathan on 11/1/2015.
 */
public class ShutdownListFragment extends ListFragment {

    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> shutdowns;
    Bundle receivedArgs;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onShutdownSelected((ShutDown) shutdowns.get(position));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        receivedArgs = getArguments();
        dbAdapter = new JITDatabaseAdapter(getActivity());
        shutdowns = dbAdapter.getShutdownsByTriggerId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdater(getActivity(), shutdowns, new MyAppSectionArrayAdater.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
                mCallback.onShutdownSelected((ShutDown) shutdowns.get(pos));
            }

            @Override
            public void OnListItemSwipe(int pos) {

            }
        }));
    }

    public interface onShutdownSelectedListener{
        public void onShutdownSelected(ShutDown selectedShutdown);
    }

    onShutdownSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onShutdownSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onShutdownSelectedListener");
        }
    }
}
