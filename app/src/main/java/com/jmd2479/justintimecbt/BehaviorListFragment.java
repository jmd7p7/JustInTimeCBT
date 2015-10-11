package com.jmd2479.justintimecbt;

import android.app.Activity;
//import android.app.ListFragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/6/2015.
 */
public class BehaviorListFragment extends ListFragment {
    JITDatabaseAdapter dbAdapter;
    ArrayList<Behavior> behaviors;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onBehaviorSelected(behaviors.get(position).behaviorId, behaviors.get(position).behavior);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        dbAdapter = new JITDatabaseAdapter(getActivity());
        behaviors = dbAdapter.getBehaviors();

        setListAdapter(new MyAppSectionArrayAdater(getActivity(), behaviors));
    }

    public interface onBehaviorSelectedListener{
        public void onBehaviorSelected(int id, String behavior);
    }

    onBehaviorSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onBehaviorSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
