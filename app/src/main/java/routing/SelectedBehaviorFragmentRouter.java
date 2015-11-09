package routing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.TwoSectionActivity;

/**
 * Created by Jonathan on 10/25/2015.
 */
public class SelectedBehaviorFragmentRouter {
    private Bundle args;
    private int viewId;
    AppCompatActivity context;
    public SelectedBehaviorFragmentRouter(int viewId, Bundle args, AppCompatActivity context){
        this.args = args;
        this.viewId = viewId;
        this.context = context;
    }

    public void handleRoute(){
        switch (viewId){
            case R.id.selected_behavior_triggers_textView:
                //Calling Fragment: SelectedBehaviorFragment
                //Calling Activity: HomeActivity
                //Destination Fragment: TriggerListFragment
                //Destination Activity: Two Section Activity
                displayTriggers();
                break;
            case R.id.selected_behavior_consequences_textView:
                //Calling Fragment: SelectedBehaviorFragment
                //Calling Activity: HomeActivity
                //Destination Fragment: ConsequenceListFragment
                //Destination Activity: Two Section Activity
                displayConsequences();
                break;
            case R.id.selected_behavior_rationalizations_textView:
                //Calling Fragment: SelectedBehaviorFragment
                //Calling Activity: HomeActivity
                //Destination Fragment: RationalizationsListFragment
                //Destination Activity: Two Section Activity
                displayRationalizations();
                break;
        }
    }

    private void displayRationalizations() {
        Intent intent = new Intent(context, TwoSectionActivity.class);
        intent.putExtra("TwoSectionActivityIndex", R.string.TWO_SECTION_RATIONALIZATION_INDEX);
        intent.putExtra("ParentId", args.getInt("ParentId"));
        intent.putExtra("BehaviorName", args.getString("BehaviorName"));
        context.startActivity(intent);
    }

    private void displayConsequences() {
        Intent intent = new Intent(context, TwoSectionActivity.class);
        intent.putExtra("TwoSectionActivityIndex", R.string.TWO_SECTION_CONSEQUENCE_INDEX);
        intent.putExtra("ParentId", args.getInt("ParentId"));
        intent.putExtra("BehaviorName", args.getString("BehaviorName"));
        context.startActivity(intent);
    }

    private void displayTriggers() {
        Intent intent = new Intent(context, TwoSectionActivity.class);
        intent.putExtra("TwoSectionActivityIndex", R.string.TWO_SECTION_TRIGGER_INDEX);
        intent.putExtra("ParentId", args.getInt("ParentId"));
        intent.putExtra("BehaviorName", args.getString("BehaviorName"));
        context.startActivity(intent);
    }
}
