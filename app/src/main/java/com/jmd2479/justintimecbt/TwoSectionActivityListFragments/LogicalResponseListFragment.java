package com.jmd2479.justintimecbt.TwoSectionActivityListFragments;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;
import com.jmd2479.justintimecbt.DataTransferObjects.LocicalResponse;
import com.jmd2479.justintimecbt.MyAppSectionArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class LogicalResponseListFragment extends ListFragment {
    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> logicalResponses;
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
        logicalResponses = dbAdapter.getLogicalResponsesByRationalizationId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdapter(getActivity(), logicalResponses, new MyAppSectionArrayAdapter.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
            }

            @Override
            public void OnListItemSwipe(int pos) {
                mCallback.onLogicalResponseEdit((LocicalResponse) logicalResponses.get(pos), receivedArgs.getInt("ParentId"));
            }
        }));
    }

    public interface onLogicalResponseSelectedListener{
        public void onLogicalResponseEdit(LocicalResponse selectedLogicalResponse, int parentId);
    }

    onLogicalResponseSelectedListener mCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onLogicalResponseSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onLogicalResponseSelectedListener");
        }
    }
}
