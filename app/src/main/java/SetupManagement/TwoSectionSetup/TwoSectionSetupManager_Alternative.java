package SetupManagement.TwoSectionSetup;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.AlternativeListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class TwoSectionSetupManager_Alternative extends TwoSectionSetupManager {

    public TwoSectionSetupManager_Alternative(String callingActivityName, AppCompatActivity context, String childName,
                                              String parentName, int parentId, String databaseTableName,
                                              int newItemSelectedIndex,
                                              android.support.v4.app.FragmentManager fragmentManager,
                                              String explanation, String description){

        super(callingActivityName, context, childName, parentName,
                parentId, databaseTableName, newItemSelectedIndex,fragmentManager,
                explanation, description);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction(){
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.two_section_bottom_container, addNewFragment);
        AlternativeListFragment alternativeListFragment = new AlternativeListFragment();
        alternativeListFragment.setArguments(destinationFragmentArgs);
        if(callingActivityName.equals("TwoSectionActivity")) {
            transaction.replace(R.id.two_section_main_container, alternativeListFragment);
            transaction.replace(R.id.two_section_top_container, pageHeaderFragment);
        }
        else{
            transaction.add(R.id.two_section_main_container, alternativeListFragment);
            transaction.add(R.id.two_section_top_container, pageHeaderFragment);
        }
        transaction.commit();
    }
}

