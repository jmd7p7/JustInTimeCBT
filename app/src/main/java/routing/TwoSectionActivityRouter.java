package routing;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jmd2479.justintimecbt.AddNewFragment;
import com.jmd2479.justintimecbt.R;

import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_Alternative;
import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_Behavior;
import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_Consequence;
import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_LogicalResponse;
import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_Rationalization;
import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_Shutdown;
import SetupManagement.TwoSectionSetup.TwoSectionSetupManager_Trigger;

/**
 * Created by Jonathan on 10/25/2015.
 */
public class TwoSectionActivityRouter {
    private int index;
    private Bundle extras;
    private Bundle args;
    private AppCompatActivity context;

    public TwoSectionActivityRouter(Bundle extras, AppCompatActivity context){
        this.index = extras.getInt("TwoSectionActivityIndex");
        this.extras = extras;
        this.context = context;
        args = new Bundle();
    }

    public void handleRoute(){
        FragmentManager fm = context.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        AddNewFragment addNewFragment = new AddNewFragment();
        switch (index){
            case R.string.TWO_SECTION_BEHAVIOR_INDEX:
                TwoSectionSetupManager_Behavior behaviorsSetupManager =
                        new TwoSectionSetupManager_Behavior(extras.getString("CallingActivityName"), context, "Behavior", "Behavior",
                                R.string.NEW_ITEM_TYPE_BEHAVIOR_INDEX, fm);
                break;
            case R.string.TWO_SECTION_TRIGGER_INDEX:
                TwoSectionSetupManager_Trigger triggersSetupManager =
                        new TwoSectionSetupManager_Trigger(extras.getString("CallingActivityName"), context, "Trigger", "Behavior",
                                extras.getInt("ParentId"), "Trigger", R.string.NEW_ITEM_TYPE_TRIGGER_INDEX,fm);
                break;
            case R.string.TWO_SECTION_CONSEQUENCE_INDEX:
                TwoSectionSetupManager_Consequence consequencesSetupManger =
                        new TwoSectionSetupManager_Consequence(extras.getString("CallingActivityName"), context, "Consequence", "Behavior",
                                extras.getInt("ParentId"), "Consequence", R.string.NEW_ITEM_TYPE_CONSEQUENCE_INDEX,fm);
                break;
            case R.string.TWO_SECTION_SHUTDOWN_INDEX:
                TwoSectionSetupManager_Shutdown twoSectionSetupManager_shutdown =
                        new TwoSectionSetupManager_Shutdown(extras.getString("CallingActivityName"), context, "Shutdown", "Trigger",
                                extras.getInt("ParentId"), "Shutdown", R.string.NEW_ITEM_TYPE_SHUTDOWN_INDEX, fm);
                break;
            case R.string.TWO_SECTION_RATIONALIZATION_INDEX:
                TwoSectionSetupManager_Rationalization twoSectionSetupManager_rationalization =
                        new TwoSectionSetupManager_Rationalization(extras.getString("CallingActivityName"), context, "Rationalization", "Behavior",
                                extras.getInt("ParentId"), "Rationalization", R.string.NEW_ITEM_TYPE_RATIONALIZATION_INDEX, fm);
                break;
            case R.string.TWO_SECTION_ALTERNATIVE_INDEX:
                TwoSectionSetupManager_Alternative alternativesSetupManager =
                        new TwoSectionSetupManager_Alternative(extras.getString("CallingActivityName"), context, "Alternative", "Behavior",
                                extras.getInt("ParentId"), "Alternative", R.string.NEW_ITEM_TYPE_ALTERNATIVE_INDEX,fm);
                break;
            case R.string.TWO_SECTION_LOGICALRESPONSE_INDEX:
                TwoSectionSetupManager_LogicalResponse logicalResponsesSetupManager =
                        new TwoSectionSetupManager_LogicalResponse(extras.getString("CallingActivityName"), context, "Logical Response", "Rationalization",
                                extras.getInt("ParentId"), "LogicalResponse", R.string.NEW_ITEM_TYPE_LOGICALRESPONSE_INDEX,fm);
                break;
        }
    }
}
