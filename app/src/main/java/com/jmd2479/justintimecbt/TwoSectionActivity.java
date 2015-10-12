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

public class TwoSectionActivity extends AppCompatActivity implements BehaviorListFragment.onBehaviorSelectedListener, TriggerListFragment.onTriggerSelectedListener {
    private FragmentManager fm;
    private AddNewFragment addNewFragment;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_section);
        fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        Bundle args = new Bundle();
        extras = getIntent().getExtras();
        int index = extras.getInt("TwoSectionActivityIndex");
        switch (index){
            case 0:
                setTitle("Behaviors");
                addNewFragment = new AddNewFragment();
                args.putString("NewItemType", "Behavior");
                args.putInt("NewItemTypeId", 0);
                addNewFragment.setArguments(args);
                transaction.replace(R.id.two_section_top_container, addNewFragment);
                BehaviorListFragment behaviorListFragment = new BehaviorListFragment();
                transaction.replace(R.id.two_section_main_container, behaviorListFragment);
                transaction.commit();
                break;
            case 1:
                setTitle(extras.getString("BehaviorName") + " Triggers");
                addNewFragment = new AddNewFragment();
                args.putString("NewItemType", "Trigger");
                args.putInt("NewItemTypeId", 1);
                args.putInt("BehaviorId", extras.getInt("BehaviorId"));
                addNewFragment.setArguments(args);
                transaction.add(R.id.two_section_top_container, addNewFragment);
                TriggerListFragment triggerListFragment = new TriggerListFragment();
                transaction.add(R.id.two_section_main_container, triggerListFragment);
                transaction.commit();
                break;
        }

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

    @Override
    public void onBehaviorSelected(int id, String behavior) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("HomeActivityIndex", getResources().getString(R.string.HOME_ACTIVITY_SELECTEDBEHAVIOR_INDEX));
        intent.putExtra("SelectedBehavior", behavior);
        intent.putExtra("BehaviorId", id);
        startActivity(intent);
    }

    @Override
    public void onTriggerSelected(int id, String trigger) {
        Toast.makeText(this, "You clicked on a trigger!", Toast.LENGTH_LONG);
    }
}
