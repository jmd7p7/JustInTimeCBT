package SetupManagement.TwoSectionSetup;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.BehaviorListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 12/10/2015.
 */
public class TwoSectionSetupManager_Behavior extends TwoSectionSetupManager {


    public TwoSectionSetupManager_Behavior(String callingActivityName, AppCompatActivity context, String childName,
                                           String databaseTableName, int newItemSelectedIndex,
                                           android.support.v4.app.FragmentManager fragmentManager) {

        super(callingActivityName, context, childName, databaseTableName, newItemSelectedIndex, fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction() {
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.two_section_top_container, addNewFragment);
            BehaviorListFragment behaviorListFragment = new BehaviorListFragment();
            behaviorListFragment.setArguments(destinationFragmentArgs);
            if(callingActivityName.equals("TwoSectionActivity")) {
                transaction.replace(R.id.two_section_main_container, behaviorListFragment);
            }
            else{
                transaction.add(R.id.two_section_main_container, behaviorListFragment);
            }
            transaction.commit();
    }
}
