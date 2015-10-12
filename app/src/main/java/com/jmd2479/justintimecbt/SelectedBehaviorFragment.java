package com.jmd2479.justintimecbt;

//import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jonathan on 10/8/2015.
 */
public class SelectedBehaviorFragment extends Fragment implements View.OnClickListener{
    private TextView triggerTextView;
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
        return theView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.selected_behavior_triggers_textView:
                Intent intent = new Intent(getActivity(), TwoSectionActivity.class);
                intent.putExtra("TwoSectionActivityIndex", 1);
                intent.putExtra("BehaviorId", args.getInt("BehaviorId"));
                intent.putExtra("BehaviorName", args.getString("BehaviorName"));
                startActivity(intent);
        }
    }
}
