package SetupManagement;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.ConsequenceListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/10/2015.
 */
public class TwoSectionChildEntitySetupManager_Consequence extends TwoSectionChildEntitySetupManager {
    public TwoSectionChildEntitySetupManager_Consequence(AppCompatActivity context, String childName,
                                                     String parentName, int parentId, String databaseTableName, int routingIndex,
                                                     android.support.v4.app.FragmentManager fragmentManager) {

        super(context, childName, parentName, parentId, databaseTableName, routingIndex, fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction(){
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.two_section_top_container, addNewFragment);
            ConsequenceListFragment consequenceListFragment = new ConsequenceListFragment();
            consequenceListFragment.setArguments(destinationFragmentArgs);
            transaction.add(R.id.two_section_main_container, consequenceListFragment);
            transaction.commit();
    }
}