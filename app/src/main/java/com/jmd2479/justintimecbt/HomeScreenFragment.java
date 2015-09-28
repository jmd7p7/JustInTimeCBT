package com.jmd2479.justintimecbt;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Jonathan on 9/22/2015.
 */
public class HomeScreenFragment extends Fragment {
    Button behaviorsBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View theView = inflater.inflate(R.layout.home_screen_fragment, container, false);
        behaviorsBtn = (Button) theView.findViewById(R.id.behaviorsBtnHome);
        behaviorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BehaviorActivity.class);
                startActivity(intent);
            }
        });
         return theView;
    }
}
