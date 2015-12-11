package SetupManagement.TwoSectionSetup;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.LogicalResponseListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class TwoSectionSetupManager_LogicalResponse extends TwoSectionSetupManager {
    public TwoSectionSetupManager_LogicalResponse(String callingActivityName, AppCompatActivity context, String childName,
                                                  String parentName, int parentId, String databaseTableName,
                                                  int newItemSelectedIndex,
                                                  android.support.v4.app.FragmentManager fragmentManager){

        super(callingActivityName, context, childName, parentName, parentId, databaseTableName, newItemSelectedIndex,fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction(){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.two_section_top_container, addNewFragment);
        LogicalResponseListFragment logicalResponseListFragment = new LogicalResponseListFragment();
        logicalResponseListFragment.setArguments(destinationFragmentArgs);
        transaction.replace(R.id.two_section_main_container, logicalResponseListFragment);
        if(!callingActivityName.equals("TwoSectionActivity")) {
            transaction.addToBackStack("logical responses for " + this.parentName);
        }
        transaction.commit();
    }
}
