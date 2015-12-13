package com.jmd2479.justintimecbt.Activities;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;

import com.jmd2479.justintimecbt.AddNewFragment;
import com.jmd2479.justintimecbt.DataTransferObjects.Alternative;
import com.jmd2479.justintimecbt.DataTransferObjects.Behavior;
import com.jmd2479.justintimecbt.DataTransferObjects.Consequence;
import com.jmd2479.justintimecbt.DataTransferObjects.LocicalResponse;
import com.jmd2479.justintimecbt.DataTransferObjects.Rationalization;
import com.jmd2479.justintimecbt.DataTransferObjects.ShutDown;
import com.jmd2479.justintimecbt.DataTransferObjects.Trigger;
import com.jmd2479.justintimecbt.DialogFragments.MyDialogCloseListener;
import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.SetupManagement.EditFragmentSetup.EditFragmentSetupManager;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.AlternativeListFragment;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.BehaviorListFragment;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.ConsequenceListFragment;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.LogicalResponseListFragment;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.RationalizationListFragment;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.ShutdownListFragment;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.TriggerListFragment;

import routing.TwoSectionActivityRouter;

public class TwoSectionActivity extends AppCompatActivity implements BehaviorListFragment.onBehaviorSelectedListener,
        TriggerListFragment.onTriggerSelectedListener, ConsequenceListFragment.onConsequenceSelectedListener,
        ShutdownListFragment.onShutdownSelectedListener, RationalizationListFragment.onRationalizationSelectedListener,
        AlternativeListFragment.onAlternativeSelectedListener, LogicalResponseListFragment.onLogicalResponseSelectedListener,
        MyDialogCloseListener{

    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_section);
        extras = getIntent().getExtras();
        extras.putString("CallingActivityName", "NotTwoSectionActivity");
        TwoSectionActivityRouter router = new TwoSectionActivityRouter(extras, this);
        router.handleRoute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_section, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Calls the HomeActivity's DisplayFragment() method
    @Override
    public void onBehaviorSelected(Behavior behavior) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("HomeActivityIndex", R.string.HOME_ACTIVITY_SELECTED_BEHAVIOR_INDEX);
        intent.putExtra("SelectedBehavior", behavior.getName());
        intent.putExtra("BehaviorId", behavior.getId());
        startActivity(intent);
    }

    @Override
    public void onBehaviorEdit(Behavior behavior){
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("Behavior", behavior.getName(),
                        "Behavior", behavior.getId(), Integer.parseInt(getResources().getString(R.string.PARENTID_DOES_NOT_EXIT)),
                        R.string.EDIT_ITEM_TYPE_BEHAVIOR_INDEX,
                        R.string.TWO_SECTION_BEHAVIOR_INDEX, getSupportFragmentManager());
    }

    @Override
    public void onTriggerSelected(Trigger selectedTrigger) {
        Bundle args = new Bundle();
        args.putInt("TwoSectionActivityIndex", R.string.TWO_SECTION_SHUTDOWN_INDEX);
        args.putString("TriggerName", selectedTrigger.getName());
        args.putInt("ParentId", selectedTrigger.getId());
        args.putString("CallingActivityName", "TwoSectionActivity");
        args.putString("DescriptionText", selectedTrigger.getName());
        TwoSectionActivityRouter router = new TwoSectionActivityRouter(args, this);
        router.handleRoute();
    }

    @Override
    public void onTriggerEdit(Trigger selectedTrigger, int parentId) {
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("Trigger", selectedTrigger.getName(), "Trigger",
                        selectedTrigger.getId(), parentId,R.string.EDIT_ITEM_TYPE_TRIGGER_INDEX,
                        R.string.TWO_SECTION_TRIGGER_INDEX, getSupportFragmentManager());
    }


    @Override
    public void onConsequenceEdit(Consequence selectedConsequence, int parentId) {
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("Consequence", selectedConsequence.getName(), "Consequence",
                        selectedConsequence.getId(),parentId, R.string.EDIT_ITEM_TYPE_CONSEQUENCE_INDEX,
                        R.string.TWO_SECTION_CONSEQUENCE_INDEX, getSupportFragmentManager());
    }


    @Override
    public void onShutdownEdit(ShutDown selectedShutdown, int parentId) {
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("Shutdown", selectedShutdown.getName(), "Shutdown",
                        selectedShutdown.getId(),parentId, R.string.EDIT_ITEM_TYPE_SHUTDOWN_INDEX,
                        R.string.TWO_SECTION_SHUTDOWN_INDEX, getSupportFragmentManager());
    }

    @Override
    public void onRationalizationSelected(Rationalization selectedRationalization) {
        Bundle args = new Bundle();
        args.putInt("TwoSectionActivityIndex", R.string.TWO_SECTION_LOGICALRESPONSE_INDEX);
        args.putInt("ParentId", selectedRationalization.getId());
        args.putString("CallingActivityName", "TwoSectionActivity");
        args.putString("DescriptionText", selectedRationalization.getName());
        TwoSectionActivityRouter router = new TwoSectionActivityRouter(args, this);
        router.handleRoute();
    }

    @Override
    public void onRationalizationEdit(Rationalization selectedRationalization, int parentId) {
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("Rationalization", selectedRationalization.getName(), "Rationalization",
                        selectedRationalization.getId(),parentId, R.string.EDIT_ITEM_TYPE_RATIONALIZATION_INDEX,
                        R.string.TWO_SECTION_RATIONALIZATION_INDEX,getSupportFragmentManager());
    }


    @Override
    public void onAlternativeEdit(Alternative selectedAlternative, int parentId) {
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("Alternative", selectedAlternative.getName(), "Alternative",
                        selectedAlternative.getId(),parentId, R.string.EDIT_ITEM_TYPE_ALTERNATIVE_INDEX,
                        R.string.TWO_SECTION_ALTERNATIVE_INDEX, getSupportFragmentManager());
    }


    @Override
    public void onLogicalResponseEdit(LocicalResponse selectedLogicalResponse, int parentId) {
        EditFragmentSetupManager editFragmentSetupManager =
                new EditFragmentSetupManager("LogicalResponse", selectedLogicalResponse.getName(), "LogicalResponse",
                        selectedLogicalResponse.getId(), parentId, R.string.EDIT_ITEM_TYPE_LOGICALRESPONSE_INDEX,
                        R.string.TWO_SECTION_LOGICALRESPONSE_INDEX,getSupportFragmentManager());
    }

    @Override
    public void handleDialogClose(int parentId, int twoSectionIndex) {
        Bundle args = new Bundle();
        args.putInt("TwoSectionActivityIndex", twoSectionIndex);
        args.putInt("ParentId", parentId);
        args.putString("CallingActivityName", "TwoSectionActivity");
        TwoSectionActivityRouter router = new TwoSectionActivityRouter(args, this);
        router.handleRoute();
    }
}
