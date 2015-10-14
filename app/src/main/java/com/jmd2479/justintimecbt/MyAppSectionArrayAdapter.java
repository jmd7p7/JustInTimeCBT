package com.jmd2479.justintimecbt;

import android.content.Context;
import android.util.Log;
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
    private final ArrayList<ListItem> values;

    public MyAppSectionArrayAdater(Context context, ArrayList<ListItem> values) {
        super(context, R.layout.app_section_list_element, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.app_section_list_element, parent, false);

        TextView appSectionNameTextView = (TextView) rowView.findViewById(R.id.app_section_name_textView);
        appSectionNameTextView.setText(values.get(position).getName());
        TextView appSectionIdTextView = (TextView) rowView.findViewById(R.id.app_section_Id_textView);
        appSectionIdTextView.setText(Integer.toString(values.get(position).getId()));

        return rowView;
    }
}
