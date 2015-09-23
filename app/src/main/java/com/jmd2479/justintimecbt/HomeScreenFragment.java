package com.jmd2479.justintimecbt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jonathan on 9/22/2015.
 */
public class HomeScreenFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View theView = inflater.inflate(R.layout.home_screen_fragment, container, false);
         return theView;
    }
}
