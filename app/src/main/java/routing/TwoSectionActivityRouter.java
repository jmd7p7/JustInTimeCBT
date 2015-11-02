package routing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.AddNewFragment;
import com.jmd2479.justintimecbt.BehaviorListFragment;
import com.jmd2479.justintimecbt.ConsequenceListFragment;
import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.TriggerListFragment;

/**
 * Created by Jonathan on 10/25/2015.
 */
public class TwoSectionActivityRouter {
    private int index;
    private Bundle extras;
    private Bundle args;
    private AppCompatActivity context;

    public TwoSectionActivityRouter(Bundle extras, AppCompatActivity context){
        this.index = extras.getInt("TwoSectionActivityIndex");
        this.extras = extras;
        this.context = context;
        args = new Bundle();
    }

    public void handleRoute(){
        FragmentManager fm = context.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        AddNewFragment addNewFragment = new AddNewFragment();
        switch (index){
            case R.string.TWO_SECTION_BEHAVIOR_INDEX:
                //Calling Fragment: HomeFragment
                //Calling Activity: HomeActivity
                //Destination Fragment: BehaviorListFragment
                //Destination Activity: TwoSectionActivity
                displayBehavior(fm, transaction, addNewFragment);
                break;
            case R.string.TWO_SECTION_TRIGGER_INDEX:
                //Calling Fragment: SelectedBehaviorFragment
                //Calling Activity: HomeActivity
                //Destination Fragment: TriggerListFragment
                //Destination Activity: TwoSectionActivity
                displayTrigger(fm, transaction, addNewFragment);
                break;
            case R.string.TWO_SECTION_CONSEQUENCE_INDEX:
                //Calling Fragment: SelectedBehaviorFragment
                //Calling Activity: HomeActivity
                //Destination Fragment: ConsequenceListFragment
                //Destination Activity: TwoSectionActivity
                displayConsequence(fm, transaction, addNewFragment);
                break;
            case R.string.TWO_SECTION_SHUTDOWN_INDEX:
                //Calling Fragment: TriggerListFragment
                //Calling Activity: TwoSectionActivity
                //Destination Fragment: ShutdownListFragment
                //Destination Activity: TwoSectionActivity
                displayShutdowns();
                break;
        }
    }

    private void displayShutdowns() {

    }


    private void displayBehavior(FragmentManager fm,
                                 android.support.v4.app.FragmentTransaction transaction,
                                 AddNewFragment addNewFragment) {
        context.setTitle("Behaviors");
        args.putString("NewItemTitle", "Behavior");
        args.putString("DatabaseTableName", "Behavior");
        args.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX);
        addNewFragment.setArguments(args);
        transaction.replace(R.id.two_section_top_container, addNewFragment);
        BehaviorListFragment behaviorListFragment = new BehaviorListFragment();
        transaction.replace(R.id.two_section_main_container, behaviorListFragment);
        transaction.commit();
    }

    private void displayTrigger(FragmentManager fm,
                                android.support.v4.app.FragmentTransaction transaction,
                                AddNewFragment addNewFragment) {
        context.setTitle(extras.getString("BehaviorName") + " Triggers");
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
    }

    private void displayConsequence(FragmentManager fm, FragmentTransaction transaction, AddNewFragment addNewFragment) {
        context.setTitle(extras.getString("BehaviorName") + " Consequences");
        args.putString("NewItemTitle", "Consequence");
        args.putString("DatabaseTableName", "Consequence");
        args.putInt("ParentId", extras.getInt("ParentId"));
        args.putInt("NewItemSelectedIndex", R.string.NEW_ITEM_TYPE_CONSEQUENCE_INDEX);
        addNewFragment.setArguments(args);
        transaction.add(R.id.two_section_top_container, addNewFragment);
        ConsequenceListFragment consequenceListFragment = new ConsequenceListFragment();
        consequenceListFragment.setArguments(args);
        transaction.add(R.id.two_section_main_container, consequenceListFragment);
        transaction.commit();
    }
}
