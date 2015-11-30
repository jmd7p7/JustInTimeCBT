package SetupManagement;

import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.AlternativeListFragment;
import com.jmd2479.justintimecbt.ConsequenceListFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class TwoSectionChildEntitySetupManager_Alternative extends TwoSectionChildEntitySetupManager {

    public TwoSectionChildEntitySetupManager_Alternative(AppCompatActivity context, String childName,
                                                     String parentName, int parentId, String databaseTableName,
                                                          int newItemSelectedIndex,
                                                     android.support.v4.app.FragmentManager fragmentManager){

        super(context, childName, parentName, parentId, databaseTableName, newItemSelectedIndex,fragmentManager);
        CreateTransaction();
    }

    @Override
    public void CreateTransaction(){
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.two_section_top_container, addNewFragment);
        AlternativeListFragment alternativeListFragment = new AlternativeListFragment();
        alternativeListFragment.setArguments(destinationFragmentArgs);
        transaction.add(R.id.two_section_main_container, alternativeListFragment);
        transaction.commit();
    }
}
