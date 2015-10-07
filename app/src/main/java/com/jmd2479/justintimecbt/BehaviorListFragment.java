package com.jmd2479.justintimecbt;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by Jonathan on 10/6/2015.
 */
public class BehaviorListFragment extends ListFragment {
    JITDatabaseAdapter dbAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "In OnActivityCreated", Toast.LENGTH_LONG);
        super.onActivityCreated(savedInstanceState);
        dbAdapter = new JITDatabaseAdapter(getActivity());
        String[] behaviors = (String[]) dbAdapter.getBehaviors().toArray();
        ArrayAdapter<String> behaviorsaAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, behaviors);
        setListAdapter(behaviorsaAdapter);
    }
}
