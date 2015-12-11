package com.jmd2479.justintimecbt.TwoSectionActivityListFragments;

import android.app.Activity;
//import android.app.ListFragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jmd2479.justintimecbt.DataTransferObjects.Behavior;
import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;
import com.jmd2479.justintimecbt.MyAppSectionArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/6/2015.
 */

//BehaviorListFragment is
public class BehaviorListFragment extends ListFragment {
    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> behaviors;


    //This method calls the onBehaviorSelected method of the parent activity, TwoSectionActivity
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onBehaviorSelected((Behavior) behaviors.get(position));

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        dbAdapter = new JITDatabaseAdapter(getActivity());
        behaviors = dbAdapter.getBehaviors();

        setListAdapter(new MyAppSectionArrayAdapter(getActivity(), behaviors, new MyAppSectionArrayAdapter.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
                mCallback.onBehaviorSelected((Behavior) behaviors.get(pos));
            }
            @Override
            public void OnListItemSwipe(int pos) {
                mCallback.onBehaviorEdit((Behavior) behaviors.get(pos));
            }
        }));

    }

    public interface onBehaviorSelectedListener{
        public void onBehaviorSelected(Behavior behavior);
        public void onBehaviorEdit(Behavior behavior);
    }

    onBehaviorSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        //
        try {
            mCallback = (onBehaviorSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
