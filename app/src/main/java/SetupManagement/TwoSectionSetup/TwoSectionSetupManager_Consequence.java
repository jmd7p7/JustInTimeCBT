package SetupManagement.TwoSectionSetup;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.TwoSectionActivityListFragments.ConsequenceListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/10/2015.
 */
public class TwoSectionSetupManager_Consequence extends TwoSectionSetupManager {
    public TwoSectionSetupManager_Consequence(String callingActivityName, AppCompatActivity context, String childName,
                                              String parentName, int parentId, String databaseTableName,
                                              int newItemSelectedIndex,
                                              android.support.v4.app.FragmentManager fragmentManager){

        super(callingActivityName, context, childName, parentName, parentId, databaseTableName, newItemSelectedIndex,fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction(){
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.two_section_top_container, addNewFragment);
            ConsequenceListFragment consequenceListFragment = new ConsequenceListFragment();
            consequenceListFragment.setArguments(destinationFragmentArgs);
            if(callingActivityName.equals("TwoSectionActivity")){
                transaction.replace(R.id.two_section_main_container, consequenceListFragment);
            }
            else {
                transaction.add(R.id.two_section_main_container, consequenceListFragment);
            }
            transaction.commit();
    }
}
