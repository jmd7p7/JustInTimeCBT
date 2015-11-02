package com.jmd2479.justintimecbt;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Jonathan on 11/1/2015.
 */
public class ChangeItemDialogFragment extends DialogFragment implements View.OnClickListener {
    private EditText editItemTextField;
    private Bundle args;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, android.R.style.Theme_Material_Dialog_MinWidth);

    }

    //NewItemDialogFragment is called by the AddNewFragment Fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_change_item_dialog, container, false);

        View saveItemChangesBtn = theView.findViewById(R.id.saveItemChangesBtn);
        saveItemChangesBtn.setOnClickListener(this);
        saveItemChangesBtn.hasFocus();

        View cancelItemChangesBtn = theView.findViewById(R.id.cancelItemChangesBtn);
        cancelItemChangesBtn.setOnClickListener(this);

        View deleteItemBtn = theView.findViewById(R.id.deleteItemBtn);
        deleteItemBtn.setOnClickListener(this);
        args = getArguments();
        editItemTextField = (EditText) theView.findViewById(R.id.editItemText);
        editItemTextField.setText(args.getString("EditItemText"));

        //setup the dialog
        Dialog dialog = getDialog();
        dialog.setTitle("Edit " + args.getString("EditItemType"));
        dialog.setCanceledOnTouchOutside(false);

        return theView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.deleteItemBtn:
                switch (args.getInt("EditItemTypeIndex")){
                    case R.string.EDIT_ITEM_TYPE_BEHAVIOR_INDEX:
                        JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                        JITDB.deleteBehavior(args.getInt("EditItemId"));
                        break;
                }
            break;
        }
    }
}
