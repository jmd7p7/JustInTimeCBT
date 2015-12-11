package com.jmd2479.justintimecbt.TwoSectionActivityListFragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.jmd2479.justintimecbt.DataTransferObjects.Consequence;
import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;
import com.jmd2479.justintimecbt.MyAppSectionArrayAdapter;

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
        setListAdapter(new MyAppSectionArrayAdapter(getActivity(), consequences, new MyAppSectionArrayAdapter.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
            }

            @Override
            public void OnListItemSwipe(int pos) {
                mCallback.onConsequenceEdit((Consequence) consequences.get(pos),receivedArgs.getInt("ParentId"));
            }
        }));
    }


    public interface onConsequenceSelectedListener{
        public void onConsequenceEdit(Consequence selectedConsequence, int parentId);
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
