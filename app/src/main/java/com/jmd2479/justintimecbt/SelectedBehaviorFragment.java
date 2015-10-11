package com.jmd2479.justintimecbt;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jonathan on 10/8/2015.
 */
public class SelectedBehaviorFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.fragment_selected_behavior, container, false);
        TextView behaviorTextView = (TextView) theView.findViewById(R.id.selected_behavior_textView);
        Bundle args = getArguments();
        behaviorTextView.setText(args.getString("BehaviorName"));
        return theView;
    }
}
