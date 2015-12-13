package com.jmd2479.justintimecbt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jmd2479.justintimecbt.DialogFragments.NewItemDialogFragment;


/**
 * Created by Jonathan on 10/11/2015.
 */
public class AddNewFragment extends Fragment implements View.OnClickListener{
    Button addNewBtn;
    Bundle args;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_add_new, container, false);

        args = getArguments();
        addNewBtn = (Button)theView.findViewById(R.id.add_new_btn);
        addNewBtn.setText("Add new " + args.getString("NewItemTitle"));
        addNewBtn.setOnClickListener(this);
        return theView;
    }

    //For each case below there's a lot of duplicate code.  If I had time I'd extract that code
    //into a method
    @Override
    public void onClick(View v) {
        int index = args.getInt("NewItemSelectedIndex");
        NewItemDialogFragment newItemDialogFragment;
        FragmentManager fragmentManager;
        Bundle newArgs = new Bundle();
        switch(index){
            case R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Behavior");
                newArgs.putString("DatabaseTableName", "Behavior");
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewBehaviorDialogFragment");
                break;
            case R.string.NEW_ITEM_TYPE_TRIGGER_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Trigger");
                newArgs.putString("DatabaseTableName", "Trigger");
                newArgs.putString("DatabaseParentTableName", "Behavior");
                newArgs.putInt("ParentId", args.getInt("ParentId"));
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_TRIGGER_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewTriggerDialogFragment");
                break;
            case R.string.NEW_ITEM_TYPE_CONSEQUENCE_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Consequence");
                newArgs.putString("DatabaseTableName", "Consequence");
                newArgs.putString("DatabaseParentTableName", "Behavior");
                newArgs.putInt("ParentId", args.getInt("ParentId"));
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_CONSEQUENCE_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewConsequenceDialogFragment");
                break;
            case R.string.NEW_ITEM_TYPE_SHUTDOWN_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Shutdown");
                newArgs.putString("DatabaseTableName", "Shutdown");
                newArgs.putString("DatabaseParentTableName", "Trigger");
                newArgs.putInt("ParentId", args.getInt("ParentId"));
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_SHUTDOWN_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewShutdownDialogFragment");
                break;
            case R.string.NEW_ITEM_TYPE_RATIONALIZATION_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Rationalization");
                newArgs.putString("DatabaseTableName", "Rationalization");
                newArgs.putString("DatabaseParentTableName", "Behavior");
                newArgs.putInt("ParentId", args.getInt("ParentId"));
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_RATIONALIZATION_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewRationalizationDialogFragment");
                break;
            case R.string.NEW_ITEM_TYPE_ALTERNATIVE_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Alternative");
                newArgs.putString("DatabaseTableName", "Alternative");
                newArgs.putString("DatabaseParentTableName", "Behavior");
                newArgs.putInt("ParentId", args.getInt("ParentId"));
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_ALTERNATIVE_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewAlternativeDialogFragment");
                break;
            case R.string.NEW_ITEM_TYPE_LOGICALRESPONSE_INDEX:
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemTitle", "Logical Response");
                newArgs.putString("DatabaseTableName", "LogicalResponse");
                newArgs.putString("DatabaseParentTableName", "Rationalization");
                newArgs.putInt("ParentId", args.getInt("ParentId"));
                newArgs.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_LOGICALRESPONSE_INDEX);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewLogicalResponseDialogFragment");
                break;
        }
    }
}
