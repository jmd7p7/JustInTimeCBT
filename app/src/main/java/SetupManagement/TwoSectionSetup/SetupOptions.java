package SetupManagement.TwoSectionSetup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.AddNewFragment;
import com.jmd2479.justintimecbt.R;

/**
 * Created by Jonathan on 12/10/2015.
 */
public class SetupOptions {
    private AppCompatActivity context;
    private String childName;
    private String parentName;
    private int parentId;
    private String databaseTableName;
    private int newItemSelectedIndex;
    private Bundle addNewFragmentArgs;
    private Bundle destinationFragmentArgs;
    private AddNewFragment addNewFragment;
    private android.support.v4.app.ListFragment listFragment;
    private android.support.v4.app.FragmentTransaction transaction;
    private android.support.v4.app.FragmentManager fragmentManager;

    public SetupOptions(AppCompatActivity context, String childName, String parentName, int parentId,
                        String databaseTableName, int newItemSelectedIndex,
                        android.support.v4.app.ListFragment listFragment,
                        android.support.v4.app.FragmentManager fragmentManager){
        this.context = context;
        this.childName = childName;
        this.parentId = parentId;
        this.parentName = parentName;
        this.databaseTableName = databaseTableName;
        this.newItemSelectedIndex = newItemSelectedIndex;
        this.addNewFragmentArgs = new Bundle();
        this.destinationFragmentArgs = new Bundle();
        this.addNewFragment = new AddNewFragment();
        this.listFragment = listFragment;
        this.fragmentManager = fragmentManager;
    }

    public SetupOptions(AppCompatActivity context, String childName,
                        String databaseTableName, int newItemSelectedIndex,
                        android.support.v4.app.ListFragment listFragment,
                        android.support.v4.app.FragmentManager fragmentManager){
        context.setTitle(childName + "s");
        this.childName = childName;
        this.databaseTableName = databaseTableName;
        this.parentId = Integer.parseInt(context.getResources().getString(R.string.PARENTID_DOES_NOT_EXIT));
        this.parentName = context.getResources().getString(R.string.PARENT_NAME_DOES_NOT_EXIT);
        this.newItemSelectedIndex = newItemSelectedIndex;
        this.addNewFragmentArgs = new Bundle();
        this.destinationFragmentArgs = new Bundle();
        this.addNewFragment = new AddNewFragment();
        this.listFragment = listFragment;
        this.fragmentManager = fragmentManager;
    }

    public String getChildName() {
        return childName;
    }

    public String getParentName() {
        return parentName;
    }

    public int getParentId() {
        return parentId;
    }

    public String getDatabaseTableName() {
        return databaseTableName;
    }

    public int getNewItemSelectedIndex() {
        return newItemSelectedIndex;
    }

    public Bundle getAddNewFragmentArgs() {
        return addNewFragmentArgs;
    }

    public Bundle getDestinationFragmentArgs() {
        return destinationFragmentArgs;
    }

    public AddNewFragment getAddNewFragment() {
        return addNewFragment;
    }

    public android.support.v4.app.ListFragment getListFragment() {
        return listFragment;
    }

    public android.support.v4.app.FragmentTransaction getTransaction() {
        return transaction;
    }

    public android.support.v4.app.FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public AppCompatActivity getContext() {
        return context;
    }
}
