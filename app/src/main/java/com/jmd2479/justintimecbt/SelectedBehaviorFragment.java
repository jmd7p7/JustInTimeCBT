package com.jmd2479.justintimecbt;


//import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import routing.SelectedBehaviorFragmentRouter;

/**
 * Created by Jonathan on 10/8/2015.
 */
public class SelectedBehaviorFragment extends Fragment implements View.OnClickListener{
    private TextView triggerTextView;
    private TextView consequenceTextView;
    private TextView rationalizationTextView;
    private Bundle args;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.fragment_selected_behavior, container, false);
        TextView behaviorTextView = (TextView) theView.findViewById(R.id.selected_behavior_textView);
        args = getArguments();
        behaviorTextView.setText(args.getString("BehaviorName"));

        triggerTextView = (TextView) theView.findViewById(R.id.selected_behavior_triggers_textView);
        triggerTextView.setOnClickListener(this);

        consequenceTextView = (TextView) theView.findViewById(R.id.selected_behavior_consequences_textView);
        consequenceTextView.setOnClickListener(this);

        rationalizationTextView = (TextView) theView.findViewById(R.id.selected_behavior_rationalizations_textView);
        rationalizationTextView.setOnClickListener(this);

        return theView;
    }

    @Override
    public void onClick(View v) {
        SelectedBehaviorFragmentRouter router = new SelectedBehaviorFragmentRouter(v.getId(), args, (AppCompatActivity) getActivity());
        router.handleRoute();
    }
}
