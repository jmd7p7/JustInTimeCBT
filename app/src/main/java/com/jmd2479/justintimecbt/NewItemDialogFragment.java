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

    private final static int BEHAVIOR_INDEX = 0;
    private final static int TRIGGER_INDEX = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, android.R.style.Theme_Material_Dialog_MinWidth);

    }

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
        dialog.setTitle("Create New " + args.getString("NewItemType"));
        dialog.setCanceledOnTouchOutside(false);

        return theView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Log.d("EEE", "In NewItemDialogFragment OnClick before switch " + args.getInt("NewItemTypeIndex"));
        switch (id) {
            case R.id.createNewItemBtn:
                switch (args.getInt("NewItemTypeIndex")) {
                    case BEHAVIOR_INDEX:
                        Log.d("EEE", "In NewItemDialogFragment OnClick Case BehaviorIndex");
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            JITDB.insertBehavior(newItemTextField.getText().toString());
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case TRIGGER_INDEX:
                        Log.d("EEE", "In NewItemDialogFragment OnClick Case TriggeriNdex");
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
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
