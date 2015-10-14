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
        //The Following two fragments will be added to the twoSectionActivity
        // 1) An addNewFragment will be added to the top section of the layout
        //    The following bundle of information needs to be added to the args
        //    - 'NewItemTitle' - the name of the item (for display purposes)
        //    - 'DatabaseTableName' - the database table name associated with the item type
        //    - 'ParentId' - If necessary, the Id of the parent item
        //    - 'DatabaseParentTableName' If necessary, the database table name assoicated with the parent item type
        //    - 'NewItemSelectedIndex' - used in the switch statement of the new item fragment to determine which new item type to create
        // 2) A ListFragment of type that matches the item being displayed
        switch (index){
            case R.string.TWO_SECTION_BEHAVIOR_INDEX://Called by
                // 1) NewItemFragment
                setTitle("Behaviors");
                addNewFragment = new AddNewFragment();
                args.putString("NewItemTitle", "Behavior");
                args.putString("DatabaseTableName", "Behavior");
                args.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX);
                addNewFragment.setArguments(args);
                transaction.replace(R.id.two_section_top_container, addNewFragment);
                // 2) New ListFragment
                BehaviorListFragment behaviorListFragment = new BehaviorListFragment();
                transaction.replace(R.id.two_section_main_container, behaviorListFragment);
                transaction.commit();
                break;
            case R.string.TWO_SECTION_TRIGGER_INDEX:
                setTitle(extras.getString("BehaviorName") + " Triggers");
                // 1) NewItemFragment
                addNewFragment = new AddNewFragment();
                args.putString("NewItemTitle", "Trigger");
                args.putString("DatabaseTableName", "Trigger");
                args.putInt("ParentId", extras.getInt("ParentId"));
                args.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_TRIGGER_INDEX);
                addNewFragment.setArguments(args);
                transaction.add(R.id.two_section_top_container, addNewFragment);
                TriggerListFragment triggerListFragment = new TriggerListFragment();
                triggerListFragment.setArguments(args);
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

    //Calls the HomeActivity's DisplayFragment() method
    @Override
    public void onBehaviorSelected(int id, String behavior) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("HomeActivityIndex", R.string.HOME_ACTIVITY_SELECTED_BEHAVIOR_INDEX);
        intent.putExtra("SelectedBehavior", behavior);
        intent.putExtra("BehaviorId", id);
        startActivity(intent);
    }

    @Override
    public void onTriggerSelected(int id, String trigger) {
        Toast.makeText(this, "You clicked on a trigger!", Toast.LENGTH_LONG);
    }
}
