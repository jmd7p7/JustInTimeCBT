package SetupManagement;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.LogicalResponseListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class TwoSectionChildEntitySetupManager_LogicalResponse extends TwoSectionChildEntitySetupManager {
    public TwoSectionChildEntitySetupManager_LogicalResponse(AppCompatActivity context, String childName,
                                                         String parentName, int parentId, String databaseTableName,
                                                         int newItemSelectedIndex,
                                                         android.support.v4.app.FragmentManager fragmentManager){

        super(context, childName, parentName, parentId, databaseTableName, newItemSelectedIndex,fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction(){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.two_section_top_container, addNewFragment);
        LogicalResponseListFragment logicalResponseListFragment = new LogicalResponseListFragment();
        logicalResponseListFragment.setArguments(destinationFragmentArgs);
        transaction.replace(R.id.two_section_main_container, logicalResponseListFragment);
        transaction.addToBackStack("logical responses");
        transaction.commit();
    }
}
