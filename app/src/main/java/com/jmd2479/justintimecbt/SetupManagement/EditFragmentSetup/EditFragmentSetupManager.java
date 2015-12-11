package com.jmd2479.justintimecbt.SetupManagement.EditFragmentSetup;

import android.os.Bundle;

import com.jmd2479.justintimecbt.DialogFragments.ChangeItemDialogFragment;

/**
 * Created by Jonathan on 12/10/2015.
 */
public class EditFragmentSetupManager {
    private Bundle args;
    private String editItemType;
    private String editItemText;
    private String DBTable;
    private int editItemId;
    private int editItemParentId;
    private int EditItemTypeIndex;
    private int twoSectionIndex;
    private android.support.v4.app.FragmentManager fragmentManager;

    public EditFragmentSetupManager(String editItemType, String editItemText,
                                    String DBTable, int editItemId, int editItemParentId, int editItemTypeIndex,
                                    int twoSectionIndex, android.support.v4.app.FragmentManager fragmentManager){
        this.editItemType = editItemType;
        this.editItemText = editItemText;
        this.DBTable = DBTable;
        this.editItemId = editItemId;
        this.editItemParentId = editItemParentId;
        this.EditItemTypeIndex = editItemTypeIndex;
        this.twoSectionIndex = twoSectionIndex;
        this.fragmentManager = fragmentManager;
        setupArgs();
        craeteEditFragment();
    }
    private void craeteEditFragment() {
        ChangeItemDialogFragment changeItemDialogFragment = new ChangeItemDialogFragment();
        changeItemDialogFragment.setArguments(this.args);
        changeItemDialogFragment.show(fragmentManager, "Edit" + this.editItemType +"DialogFragment");
    }
    private void setupArgs() {
        args = new Bundle();
        args.putString("EditItemType", this.editItemType);
        args.putString("EditItemText", this.editItemText);
        args.putInt("EditItemId", this.editItemId);
        args.putInt("ParentId", this.editItemParentId);
        args.putString("DBTable", this.DBTable);
        args.putInt("EditItemTypeIndex", this.EditItemTypeIndex);
        args.putInt("TwoSectionIndex", this.twoSectionIndex);
    }
}
