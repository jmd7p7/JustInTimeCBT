package com.jmd2479.justintimecbt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;
import com.jmd2479.justintimecbt.UI.OnSwipeTouchListener;

import java.util.ArrayList;

/**
 * Created by Jonathan on 10/7/2015.
 */
public class MyAppSectionArrayAdapter extends ArrayAdapter {
    private final Context context;
    private final ArrayList<ListItem> values;
    ImCallBack imCallBack;

    public MyAppSectionArrayAdapter(Context context, ArrayList<ListItem> values, ImCallBack imCallBack) {
        super(context, R.layout.app_section_list_element, values);
        this.context = context;
        this.values = values;
        this.imCallBack = imCallBack;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.app_section_list_element, parent, false);

        TextView appSectionNameTextView = (TextView) rowView.findViewById(R.id.app_section_name_textView);
        appSectionNameTextView.setText(values.get(position).getName());
        rowView.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipe(){
                Toast.makeText(context, "Swiping...", Toast.LENGTH_SHORT).show();
                imCallBack.OnListItemSwipe(position);
            }
            @Override
            public void onClick(){
                Toast.makeText(context, "Position:" + position, Toast.LENGTH_SHORT).show();
                imCallBack.OnListItemClick(position);
            }
        });
        return rowView;
    }
    public interface ImCallBack{
        public void OnListItemClick(int pos);
        public void OnListItemSwipe(int pos);
    }
}
