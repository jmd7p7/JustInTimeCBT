package SetupManagement.TwoSectionSetup;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.ShutdownListFragment;

/**
 * Created by Jonathan on 12/10/2015.
 */
public class TwoSectionSetupManager_Shutdown extends TwoSectionSetupManager{

    public TwoSectionSetupManager_Shutdown(String callingActivityName, AppCompatActivity context, String childName,
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
        ShutdownListFragment shutdownListFragment = new ShutdownListFragment();
        shutdownListFragment.setArguments(destinationFragmentArgs);
        transaction.replace(R.id.two_section_main_container, shutdownListFragment);
        transaction.addToBackStack("Shutdowns for " + this.parentName);
        transaction.commit();
    }
}
