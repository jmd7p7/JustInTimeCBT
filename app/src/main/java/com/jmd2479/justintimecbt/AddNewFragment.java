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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_add_new, container, false);

        args = getArguments();
        addNewBtn = (Button)theView.findViewById(R.id.add_new_btn);
        addNewBtn.setText("Add new " + args.getString("NewItemType"));
        addNewBtn.setOnClickListener(this);
        return theView;
    }

    @Override
    public void onClick(View v) {
        int index = args.getInt("AppSectionIndex");
        NewItemDialogFragment newItemDialogFragment;
        FragmentManager fragmentManager;
        Bundle newArgs = new Bundle();
        switch(index){
            case BEHAVIOR_INDEX:
                Log.d("EEE", "In AddNewFragment OnClick before switch case behsvior index");
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putString("NewItemType", "Behavior");
                newArgs.putInt("NewItemTypeIndex", 0);
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewBehaviorFragment");
                break;
            case TRIGGER_INDEX:
                Log.d("EEE", "In AddNewFragment OnClick before switch case trigger index");
                newItemDialogFragment = new NewItemDialogFragment();
                newArgs.putInt("BehaviorId", args.getInt("BehaviorId"));
                newArgs.putInt("NewItemTypeIndex", 1);
                newArgs.putString("NewItemType", "Trigger");
                newItemDialogFragment.setArguments(newArgs);
                fragmentManager = getFragmentManager();
                newItemDialogFragment.show(fragmentManager, "AddNewTriggerFragment");
                break;

        }
    }
}
