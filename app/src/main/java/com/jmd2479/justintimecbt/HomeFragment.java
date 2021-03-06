package com.jmd2479.justintimecbt;

import android.app.Activity;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
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
    TextView behaviorTextView,rationalThoughtTextView, motivationTextView, goalsTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView =  inflater.inflate(R.layout.fragment_home, container, false);

        //onclick listeners for clicking on the text views
        behaviorTextView = (TextView) theView.findViewById(R.id.app_section_behavior_textView);
        behaviorTextView.setOnClickListener(this);
        rationalThoughtTextView = (TextView) theView.findViewById(R.id.app_section_rational_thought_textView);
        rationalThoughtTextView.setOnClickListener(this);
        motivationTextView = (TextView) theView.findViewById(R.id.app_section_motivation_textView);
        motivationTextView.setOnClickListener(this);
        goalsTextView = (TextView) theView.findViewById(R.id.app_section_goals_textView);
        goalsTextView.setOnClickListener(this);

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
    //This OnClick() method will call the HomeActivity's onAppSectionSelected method, passing
    //in the index that corresponds to the section of the app the user wishes to navigate to
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.app_section_behavior_textView:
                mCallback.onAppSectionSelected(R.string.BEHAVIOR_SECTION_INDEX);
                break;
            case R.id.app_section_rational_thought_textView:
                mCallback.onAppSectionSelected(R.string.RATIONAL_THOUGHT_SECTION_INDEX);
                break;
            case R.id.app_section_motivation_textView:
                mCallback.onAppSectionSelected(R.string.MOTIVATION_SECTION_INDEX);
                break;
            case R.id.app_section_goals_textView:
                mCallback.onAppSectionSelected(R.string.GOALS_SECTION_INDEX);
                break;
        }
    }

}
