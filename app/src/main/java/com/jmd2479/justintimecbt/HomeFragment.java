package com.jmd2479.justintimecbt;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jonathan on 10/6/2015.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView =  inflater.inflate(R.layout.fragment_home, container, false);

        //onclick listeners for clicking on the text views
        TextView behaviorTextView = (TextView) theView.findViewById(R.id.app_section_behavior_textView);
        behaviorTextView.setOnClickListener(this);

        return theView;
    }

    public interface onAppSectionListener{
        public void onAppSectionSelected(int index);
    }

    onAppSectionListener mCallback;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (onAppSectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.app_section_behavior_textView:
                mCallback.onAppSectionSelected(0);
                break;
            case R.id.app_section_rational_thought_textView:
                mCallback.onAppSectionSelected(1);
                break;
            case R.id.app_section_motivation_textView:
                mCallback.onAppSectionSelected(2);
                break;
            case R.id.app_section_goals_textView:
                mCallback.onAppSectionSelected(3);
                break;
        }
    }

}
