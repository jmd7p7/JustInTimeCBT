package SetupManagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.AddNewFragment;

/**
 * Created by Jonathan on 11/10/2015.
 */
public abstract class TwoSectionChildEntitySetupManager {
    private String childName;
    private int parentId;
    private String databaseTableName;
    private int newItemSelectedIndex;
    private Bundle addNewFragmentArgs;
    protected Bundle destinationFragmentArgs;
    protected AddNewFragment addNewFragment;
    protected android.support.v4.app.FragmentTransaction transaction;
    protected android.support.v4.app.FragmentManager fragmentManager;

    public TwoSectionChildEntitySetupManager(AppCompatActivity context, String childName, String parentName, int parentId,
        String databaseTableName, int newItemSelectedIndex, android.support.v4.app.FragmentManager fragmentManager){
        context.setTitle(childName + "s");
        this.childName = childName;
        this.parentId = parentId;
        this.databaseTableName = databaseTableName;
        this.newItemSelectedIndex = newItemSelectedIndex;
        this.addNewFragmentArgs = new Bundle();
        this.destinationFragmentArgs = new Bundle();
        this.addNewFragment = new AddNewFragment();
        this.fragmentManager = fragmentManager;
        CreateAddNewFragmentArgs();
        CreateDestinationFragmentArgs();
    }

    private void CreateAddNewFragmentArgs() {
        addNewFragmentArgs.putString("NewItemTitle", this.childName);
        addNewFragmentArgs.putString("DatabaseTableName", this.databaseTableName);
        addNewFragmentArgs.putInt("ParentId", parentId);
        addNewFragmentArgs.putInt("NewItemSelectedIndex", newItemSelectedIndex);
        addNewFragment.setArguments(addNewFragmentArgs);
    }

    private void CreateDestinationFragmentArgs() {
        destinationFragmentArgs.putInt("ParentId", parentId);
    }

    public abstract void CreateTransaction();


}
