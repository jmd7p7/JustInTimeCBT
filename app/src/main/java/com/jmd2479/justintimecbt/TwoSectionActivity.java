package com.jmd2479.justintimecbt;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import routing.TwoSectionActivityRouter;

public class TwoSectionActivity extends AppCompatActivity implements BehaviorListFragment.onBehaviorSelectedListener,
        TriggerListFragment.onTriggerSelectedListener, ConsequenceListFragment.onConsequenceSelectedListener,
        ShutdownListFragment.onShutdownSelectedListener{
    private FragmentManager fm;
    private AddNewFragment addNewFragment;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_section);
        extras = getIntent().getExtras();

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
        Bundle newArgs = new Bundle();
        ChangeItemDialogFragment changeItemDialogFragment = new ChangeItemDialogFragment();
        newArgs.putString("EditItemType", "Behavior");
        newArgs.putString("EditItemText", behavior.getName());
        newArgs.putInt("EditItemId", behavior.getId());
        newArgs.putString("DBTable", "Behavior");
        newArgs.putInt("EditItemTypeIndex", R.string.EDIT_ITEM_TYPE_BEHAVIOR_INDEX);
        changeItemDialogFragment.setArguments(newArgs);
        FragmentManager fragmentManager = getSupportFragmentManager();
        changeItemDialogFragment.show(fragmentManager, "AddNewBehaviorDialogFragment");
    }

    @Override
    public void onTriggerSelected(Trigger selectedTrigger) {
        TwoSectionActivityRouter router = new TwoSectionActivityRouter(extras, this);
        router.handleRoute();
    }

    @Override
    public void onConsequenceSelected(Consequence selectedConsequence) {
        Toast.makeText(this, "You clicked on a consequence!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onShutdownSelected(ShutDown selectedShutdown) {
        Toast.makeText(this, "You clicked on a ShutDown!", Toast.LENGTH_LONG).show();
    }
}
