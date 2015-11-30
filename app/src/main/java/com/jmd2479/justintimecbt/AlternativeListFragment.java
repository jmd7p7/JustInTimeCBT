package com.jmd2479.justintimecbt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class AlternativeListFragment extends ListFragment {

    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> alternatives;
    Bundle receivedArgs;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onAlternativeSelected((Alternative) alternatives.get(position));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        receivedArgs = getArguments();
        dbAdapter = new JITDatabaseAdapter(getActivity());
        alternatives = dbAdapter.getAlternativesByBehaviorId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdater(getActivity(), alternatives, new MyAppSectionArrayAdater.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
                mCallback.onAlternativeSelected((Alternative) alternatives.get(pos));
            }

            @Override
            public void OnListItemSwipe(int pos) {
                mCallback.onAlternativeEdit((Alternative) alternatives.get(pos));
            }
        }));
    }

    public interface onAlternativeSelectedListener{
        public void onAlternativeSelected(Alternative selectedAlternative);
        public void onAlternativeEdit(Alternative selectedAlternative);
    }

    onAlternativeSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onAlternativeSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onAlternativeSelectedListener");
        }
    }
}
