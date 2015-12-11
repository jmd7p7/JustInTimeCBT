package com.jmd2479.justintimecbt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jonathan on 12/11/2015.
 */
public class PageHeaderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View theView = inflater.inflate(R.layout.fragment_page_header, container, false);
        Bundle args = new Bundle();
        args = getArguments();

        TextView headerExplanation = (TextView) theView.findViewById(R.id.header_explanation);
        headerExplanation.setText(args.getString("Explanation"));

        TextView headerDescription = (TextView) theView.findViewById(R.id.header_description);
        headerDescription.setText(args.getString("Description"));

        return theView;
    }
}
