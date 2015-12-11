package com.jmd2479.justintimecbt.TwoSectionActivityListFragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;
import com.jmd2479.justintimecbt.MyAppSectionArrayAdapter;
import com.jmd2479.justintimecbt.DataTransferObjects.ShutDown;

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
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        receivedArgs = getArguments();
        dbAdapter = new JITDatabaseAdapter(getActivity());
        shutdowns = dbAdapter.getShutdownsByTriggerId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdapter(getActivity(), shutdowns, new MyAppSectionArrayAdapter.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
            }

            @Override
            public void OnListItemSwipe(int pos) {
                mCallback.onShutdownEdit((ShutDown) shutdowns.get(pos), receivedArgs.getInt("ParentId"));
            }
        }));
    }

    public interface onShutdownSelectedListener{
        public void onShutdownEdit(ShutDown selectedShutdown, int parentId);
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
