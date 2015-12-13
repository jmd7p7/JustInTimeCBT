package com.jmd2479.justintimecbt.DialogFragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.R;

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

    public void onDismiss(DialogInterface dialog) {
        Activity activity = getActivity();
        if (activity instanceof MyDialogCloseListener)
            ((MyDialogCloseListener) activity).handleDialogClose(
                    args.getInt("ParentId"), args.getInt("TwoSectionIndex"));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
        switch (id) {
            case R.id.deleteItemBtn:
                switch (args.getInt("EditItemTypeIndex")) {
                    case R.string.EDIT_ITEM_TYPE_BEHAVIOR_INDEX:
                        JITDB.deleteBehavior(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_TRIGGER_INDEX:
                        JITDB.deleteTrigger(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_CONSEQUENCE_INDEX:
                        JITDB.deleteConsequence(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_SHUTDOWN_INDEX:
                        JITDB.deleteShutdown(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_RATIONALIZATION_INDEX:
                        JITDB.deleteRationalization(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_ALTERNATIVE_INDEX:
                        JITDB.deleteAlternative(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_LOGICALRESPONSE_INDEX:
                        JITDB.deleteLogicalResponse(args.getInt("EditItemId"));
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                }
                break;
            case R.id.cancelItemChangesBtn:
                ChangeItemDialogFragment.this.dismiss();
                break;
            case R.id.saveItemChangesBtn:
                switch (args.getInt("EditItemTypeIndex")) {
                    case R.string.EDIT_ITEM_TYPE_BEHAVIOR_INDEX:
                        JITDB.updateBehavior(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_TRIGGER_INDEX:
                        JITDB.updateTrigger(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_CONSEQUENCE_INDEX:
                        JITDB.updateConsequence(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_SHUTDOWN_INDEX:
                        JITDB.updateShutdown(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_RATIONALIZATION_INDEX:
                        JITDB.updateRationalization(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_ALTERNATIVE_INDEX:
                        JITDB.updateAlternative(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                    case R.string.EDIT_ITEM_TYPE_LOGICALRESPONSE_INDEX:
                        JITDB.updateLogicalResponse(args.getInt("EditItemId"), editItemTextField.getText().toString());
                        ChangeItemDialogFragment.this.dismiss();
                        break;
                }
        }
    }
}