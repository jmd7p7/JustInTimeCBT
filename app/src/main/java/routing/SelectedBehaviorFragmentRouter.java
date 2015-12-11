package routing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.Activities.TwoSectionActivity;

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
                display(R.string.TWO_SECTION_TRIGGER_INDEX);
                break;
            case R.id.selected_behavior_consequences_textView:
                display(R.string.TWO_SECTION_CONSEQUENCE_INDEX);
                break;
            case R.id.selected_behavior_rationalizations_textView:
                display(R.string.TWO_SECTION_RATIONALIZATION_INDEX);
                break;
            case R.id.selected_behavior_alternatives_textView:
                display(R.string.TWO_SECTION_ALTERNATIVE_INDEX);
                break;
        }
    }

    private void display(int twoSectionIndex) {
        Intent intent = new Intent(context, TwoSectionActivity.class);
        intent.putExtra("TwoSectionActivityIndex", twoSectionIndex);
        intent.putExtra("ParentId", args.getInt("ParentId"));
        intent.putExtra("BehaviorName", args.getString("BehaviorName"));
        intent.putExtra("DescriptionText", args.getString("BehaviorName"));
        context.startActivity(intent);
    }
}
