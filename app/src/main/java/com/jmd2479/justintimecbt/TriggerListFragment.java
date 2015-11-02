package com.jmd2479.justintimecbt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/11/2015.
 */
public class TriggerListFragment extends ListFragment {
    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> triggers;
    Bundle receivedArgs;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onTriggerSelected((Trigger) triggers.get(position));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        receivedArgs = getArguments();
        dbAdapter = new JITDatabaseAdapter(getActivity());
        triggers = dbAdapter.getTriggersByBehaviorId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdater(getActivity(), triggers, new MyAppSectionArrayAdater.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
                mCallback.onTriggerSelected((Trigger) triggers.get(pos));
            }

            @Override
            public void OnListItemSwipe(int pos) {

            }
        }));
    }

    public interface onTriggerSelectedListener{
        public void onTriggerSelected(Trigger selectedTrigger);
    }

    onTriggerSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onTriggerSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onTriggerSelectedListener");
        }
    }
}
