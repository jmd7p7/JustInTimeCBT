package com.jmd2479.justintimecbt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/7/2015.
 */
class MyAppSectionArrayAdater extends ArrayAdapter {
    private final Context context;
    private final ArrayList<Behavior> values;

    public MyAppSectionArrayAdater(Context context, ArrayList<Behavior> values) {
        super(context, R.layout.app_section_list_element, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.app_section_list_element, parent, false);

        TextView behaviorView = (TextView) rowView.findViewById(R.id.app_section_behavior_textView);
        behaviorView.setText(values.get(position).behavior);

        TextView descriptionView = (TextView) rowView.findViewById(R.id.app_section_Id_textView);
        descriptionView.setText(values.get(position).behaviorId);
        
        return rowView;
    }
}
