package com.jmd2479.justintimecbt;

import android.app.Dialog;
//import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jonathan on 10/10/2015.
 */
public class NewBehaviorDialogFragment extends DialogFragment implements View.OnClickListener{
    EditText newBehaviorTextField;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, android.R.style.Theme_Material_Dialog_MinWidth);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_new_behavior_dialog, container, false);

        View createNewBehaviorBtn = theView.findViewById(R.id.createNewBehaviorBtn);
        createNewBehaviorBtn.setOnClickListener(this);
        createNewBehaviorBtn.hasFocus();

        View cancelNewBehaviorBtn = theView.findViewById(R.id.cancelNewBehaviorBtn);
        cancelNewBehaviorBtn.setOnClickListener(this);

        newBehaviorTextField = (EditText) theView.findViewById(R.id.newBehaviorNameEditText);

        //setup the dialog
        Dialog dialog = getDialog();
        dialog.setTitle("Create New Behavior");
        dialog.setCanceledOnTouchOutside(false);

        return theView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.createNewBehaviorBtn:{
                JITDatabaseAdapter JITDB = new JITDatabaseAdapter(getActivity());
                JITDB.insertBehavior(newBehaviorTextField.getText().toString());
                NewBehaviorDialogFragment.this.dismiss();
                break;
            }
            case R.id.cancelNewBehaviorBtn:{
                NewBehaviorDialogFragment.this.dismiss();
                break;
            }
        }
    }
}
