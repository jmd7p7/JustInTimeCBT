package com.jmd2479.justintimecbt.DialogFragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jmd2479.justintimecbt.DataTransferObjects.Consequence;
import com.jmd2479.justintimecbt.DataTransferObjects.Alternative;
import com.jmd2479.justintimecbt.DataTransferObjects.LocicalResponse;
import com.jmd2479.justintimecbt.DataTransferObjects.Trigger;
import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.DataTransferObjects.Rationalization;

import java.security.InvalidParameterException;

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
        int id = v.getId();
        switch (id) {
            case R.id.createNewItemBtn:
                switch (args.getInt("NewItemSelectedIndex")) {
                    case R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            JITDB.insertBehavior(newItemTextField.getText().toString());
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_TRIGGER_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            try {
                                JITDB.insertTriggerByBehaviorId(new Trigger(
                                        newItemTextField.getText().toString(), args.getInt("ParentId")));
                            }
                            catch (InvalidParameterException ex){
                                Toast.makeText(getActivity(), "Please enter some text.", Toast.LENGTH_LONG).show();
                                return;
                            }
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_CONSEQUENCE_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            try {
                                JITDB.insertConsequenceByBehaviorId(new Consequence(
                                        newItemTextField.getText().toString(), args.getInt("ParentId")));
                            }
                            catch(InvalidParameterException ex){
                                Toast.makeText(getActivity(), "Please enter some text.", Toast.LENGTH_LONG).show();
                                return;
                            }
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_SHUTDOWN_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            String newShutdown = newItemTextField.getText().toString();
                            int triggerId = args.getInt("ParentId");
                            JITDB.insertShutdownByTriggerId(newShutdown, triggerId);
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_RATIONALIZATION_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            try {
                                JITDB.insertRationalizationByBehaviorId(new Rationalization(newItemTextField.getText().toString(), args.getInt("ParentId")));
                            }
                            catch (InvalidParameterException ex){
                                Toast.makeText(getActivity(), "Please enter some text.", Toast.LENGTH_LONG).show();
                                return;
                            }
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_ALTERNATIVE_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            try {
                                JITDB.insertAlternativeByBehaviorId(new Alternative(
                                        newItemTextField.getText().toString(), args.getInt("ParentId")));
                            }
                            catch(InvalidParameterException ex){
                                Toast.makeText(getActivity(), "Please enter some text.", Toast.LENGTH_LONG).show();
                                return;
                            }
                            NewItemDialogFragment.this.dismiss();
                        }
                        break;
                    case R.string.NEW_ITEM_TYPE_LOGICALRESPONSE_INDEX:
                        if(newItemTextField.getText().toString() != "" && newItemTextField.getText().toString() != null) {
                            JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                            try {
                                JITDB.insertLogicalResponseByRationalizationId(new LocicalResponse(
                                        newItemTextField.getText().toString(), args.getInt("ParentId")));
                            }
                            catch(InvalidParameterException ex){
                                Toast.makeText(getActivity(), "Please enter some text.", Toast.LENGTH_LONG).show();
                                return;
                            }
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
