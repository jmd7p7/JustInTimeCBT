package com.jmd2479.justintimecbt;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jonathan on 11/8/2015.
 */
public class RationalizationListFragment extends ListFragment{
    JITDatabaseAdapter dbAdapter;
    ArrayList<ListItem> rationalizations;
    Bundle receivedArgs;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onRationalizationSelected((Rationalization) rationalizations.get(position));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        receivedArgs = getArguments();
        dbAdapter = new JITDatabaseAdapter(getActivity());
        rationalizations = dbAdapter.getRationalizationsByBehaviorId(receivedArgs.getInt("ParentId"));
        setListAdapter(new MyAppSectionArrayAdater(getActivity(), rationalizations, new MyAppSectionArrayAdater.ImCallBack() {
            @Override
            public void OnListItemClick(int pos) {
                mCallback.onRationalizationSelected((Rationalization) rationalizations.get(pos));
            }

            @Override
            public void OnListItemSwipe(int pos) {
                mCallback.onRationalizationEdit((Rationalization) rationalizations.get(pos));
            }
        }));
    }

    public interface onRationalizationSelectedListener{
        public void onRationalizationSelected(Rationalization selectedRationalization);
        public void onRationalizationEdit(Rationalization selectedRationalization);
    }

    onRationalizationSelectedListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onRationalizationSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement onRationalizationSelectedListener");
        }
    }


}
