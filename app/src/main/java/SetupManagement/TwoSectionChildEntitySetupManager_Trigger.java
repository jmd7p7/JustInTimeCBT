package SetupManagement;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.TriggerListFragment;

/**
 * Created by Jonathan on 11/10/2015.
 */
public class TwoSectionChildEntitySetupManager_Trigger extends TwoSectionChildEntitySetupManager {

    public TwoSectionChildEntitySetupManager_Trigger(AppCompatActivity context, String childName,
                String parentName, int parentId, String databaseTableName, int routingIndex,
                android.support.v4.app.FragmentManager fragmentManager){

        super(context, childName, parentName, parentId, databaseTableName, routingIndex, fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction() {
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.two_section_top_container, addNewFragment);
        TriggerListFragment triggerListFragment = new TriggerListFragment();
        triggerListFragment.setArguments(destinationFragmentArgs);
        transaction.add(R.id.two_section_main_container, triggerListFragment);
        transaction.commit();
    }
}
