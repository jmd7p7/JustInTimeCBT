package com.jmd2479.justintimecbt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/25/2015.
 */
public class ConsequenceListFragment extends ListFragment {
    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> consequences;
    Bundle receivedArgs;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        receivedArgs = getArguments();
        dbAdapter = new JITDatabaseAdapter(getActivity());
        consequences = dbAdapter.getConsequencesByBehaviorId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdater(getActivity(), consequences));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onConsequenceSelected(consequences.get(position).getId(), consequences.get(position).getName());
    }

    public interface onConsequenceSelectedListener{
        public void onConsequenceSelected(int id, String trigger);
    }

    onConsequenceSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onConsequenceSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onConsequenceSelectedListener");
        }
    }
}
