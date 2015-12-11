package SetupManagement.TwoSectionSetup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.AddNewFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 11/10/2015.
 */
public abstract class TwoSectionSetupManager {
    protected AppCompatActivity context;
    private String childName, databaseTableName;
    protected String parentName;
    protected String callingActivityName;
    private int parentId, newItemSelectedIndex;
    private Bundle addNewFragmentArgs;
    protected Bundle destinationFragmentArgs;
    protected AddNewFragment addNewFragment;
    protected android.support.v4.app.ListFragment listFragment;
    protected android.support.v4.app.FragmentTransaction transaction;
    protected android.support.v4.app.FragmentManager fragmentManager;

    public TwoSectionSetupManager(SetupOptions options) {
        options.getContext().setTitle(options.getChildName() + "s");
        this.context = options.getContext();
        this.childName = options.getChildName();
        this.parentId = options.getParentId();
        this.parentName = options.getParentName();
        this.databaseTableName = options.getDatabaseTableName();
        this.newItemSelectedIndex = options.getNewItemSelectedIndex();
        this.addNewFragmentArgs = new Bundle();
        this.destinationFragmentArgs = new Bundle();
        this.addNewFragment = new AddNewFragment();
        this.listFragment = options.getListFragment();
        this.fragmentManager = options.getFragmentManager();
        CreateAddNewFragmentArgs();
        CreateMainFragmentArgs();
    }

    public TwoSectionSetupManager(String callingActivityName, AppCompatActivity context, String childName, String parentName, int parentId,
                                  String databaseTableName, int newItemSelectedIndex, android.support.v4.app.FragmentManager fragmentManager){
        context.setTitle(childName + "s");
        this.callingActivityName = callingActivityName;
        this.context = context;
        this.childName = childName;
        this.parentId = parentId;
        this.parentName = parentName;
        this.databaseTableName = databaseTableName;
        this.newItemSelectedIndex = newItemSelectedIndex;
        this.addNewFragmentArgs = new Bundle();
        this.destinationFragmentArgs = new Bundle();
        this.addNewFragment = new AddNewFragment();
        this.fragmentManager = fragmentManager;
        CreateAddNewFragmentArgs();
        CreateMainFragmentArgs();
    }

    public TwoSectionSetupManager(String callingActivityName, AppCompatActivity context, String childName, String databaseTableName,
                                  int newItemSelectedIndex, android.support.v4.app.FragmentManager fragmentManager){
        context.setTitle(childName + "s");
        this.callingActivityName = callingActivityName;
        this.context = context;
        this.childName = childName;
        this.databaseTableName = databaseTableName;
        this.parentId = Integer.parseInt(context.getResources().getString(R.string.PARENTID_DOES_NOT_EXIT));
        this.newItemSelectedIndex = newItemSelectedIndex;
        this.addNewFragmentArgs = new Bundle();
        this.destinationFragmentArgs = new Bundle();
        this.addNewFragment = new AddNewFragment();
        this.fragmentManager = fragmentManager;
        CreateAddNewFragmentArgs();
        CreateMainFragmentArgs();
    }

    private void CreateAddNewFragmentArgs() {
        addNewFragmentArgs.putString("NewItemTitle", this.childName);
        addNewFragmentArgs.putString("DatabaseTableName", this.databaseTableName);
        addNewFragmentArgs.putInt("ParentId", parentId);
        addNewFragmentArgs.putInt("NewItemSelectedIndex", newItemSelectedIndex);
        addNewFragment.setArguments(addNewFragmentArgs);
    }
    private void CreateMainFragmentArgs() {
        destinationFragmentArgs.putInt("ParentId", parentId);
    }
    public abstract void CreateTransaction();
}
