package com.jmd2479.justintimecbt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Jonathan on 10/11/2015.
 */
public class AddNewFragment extends Fragment implements View.OnClickListener{
    Button addNewBtn;
    Bundle args;
    private final static int BEHAVIOR_INDEX = 0;
    private final static int TRIGGER_INDEX = 1;

    //AddNewFragment is called by the TwoSectionActivity.  This is the top section of the two section activity.
    //    The following bundle of information may/may not be retrieved from the args sent to this fragment
    //    - 'NewItemTitle' - the name of the item (for display purposes)
    //    - 'DatabaseTableName' - the database table name associated with the item type
    //    - 'ParentId' - If necessary, the Id of the parent item
    //    - 'DatabaseParentTableName' If necessary, the database table name assoicated with the parent item type
    //    - 'NewItemSelectedIndex' - used in the switch statement of the new item fragment to determine which new item type to create
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


    //OnClick will create a newItemDialogFragment
    //The following information will be sent as args to the newItemDialogFragment
    //    - 'NewItemTitle' - the name of the item (for display purposes)
    //    - 'DatabaseTableName' - the database table name associated with the item type
    //    - 'ParentId' - If necessary, the Id of the parent item
    //    - 'DatabaseParentTableName' If necessary, the database table name assoicated with the parent item type
    //    - 'NewItemSelectedIndex' - used in the switch statement of the new item fragment to determine which new item type to create
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

        }
    }
}
