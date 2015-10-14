package com.jmd2479.justintimecbt;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Jonathan on 10/11/2015.
 */
public class NewItemDialogFragment extends DialogFragment implements View.OnClickListener{
    private EditText newItemTextField;
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
        View theView = inflater.inflate(R.layout.fragment_new_item_dialog, container, false);

        View createNewBehaviorBtn = theView.findViewById(R.id.createNewItemBtn);
        createNewBehaviorBtn.setOnClickListener(this);
        createNewBehaviorBtn.hasFocus();

        View cancelNewBehaviorBtn = theView.findViewById(R.id.cancelNewItemBtn);
        cancelNewBehaviorBtn.setOnClickListener(this);

        newItemTextField = (EditText) theView.findViewById(R.id.newItemNameEditText);
        args = getArguments();
        //setup the dialog
        Dialog dialog = getDialog();
        dialog.setTitle("Create New " + args.getString("NewItemTitle"));
        dialog.setCanceledOnTouchOutside(false);

        return theView;
    }

    @Override
    public void onClick(View v) {
        Log.d("EEE", "In NewItemDialogFragment OnClick");
        int id = v.getId();
        switch (id) {
            case R.id.createNewItemBtn:
                switch (args.getInt("NewItemSelectedIndex")) {
                    case R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX:
                        Log.d("EEE", "In NewItemDialogFragment OnClick Case BehaviorIndex");
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            JITDB.insertBehavior(newItemTextField.getText().toString());
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_TRIGGER_INDEX:
                        Log.d("EEE", "In NewItemDialogFragment OnClick Case TriggeriNdex");
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            Log.d("EEE", "In NewItemDialogFragment OnClick Case TriggeriNdex - in the if sttatment");
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            String newTriggerName= newItemTextField.getText().toString();
                            int behaviorId = args.getInt("BehaviorId");
                            JITDB.insertTriggerByBehaviorId(newTriggerName, behaviorId);
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;

                }
            case R.id.cancelNewItemBtn:
                NewItemDialogFragment.this.dismiss();
                break;
        }
    }
}
