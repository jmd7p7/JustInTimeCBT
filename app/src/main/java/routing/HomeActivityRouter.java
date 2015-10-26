package routing;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jmd2479.justintimecbt.HomeFragment;
import com.jmd2479.justintimecbt.R;
import com.jmd2479.justintimecbt.SelectedBehaviorFragment;

/**
 * Created by Jonathan on 10/25/2015.
 */
public class HomeActivityRouter {
    private Bundle extras;
    private AppCompatActivity context;
    private int homeActivityIndex;
    public HomeActivityRouter(Bundle extras, AppCompatActivity context){
        if(extras != null){
            this.extras = extras;
        }
        else{
            this.extras = null;
        }
        this.context = context;
    }

    public void handleRoute(){
        switch (extras.getInt("HomeActivityIndex")){
            case R.string.HOME_ACTIVITY_HOME_FRAGMENT_INDEX:
                //Calling Fragment: N/A
                //Calling Activity: N/A
                //Destination Fragment: HomeFragment
                //Destination Activity: Home Activity
                displayHomeFragment();
                break;
            case R.string.HOME_ACTIVITY_SELECTED_BEHAVIOR_INDEX:
                //Calling Fragment: BehaviorListFragment
                //Calling Activity: TwoSectionActivity
                //Destination Fragment: SelectedBehaviorFragment
                //Destination Activity: Home Activity
                displaySelectedBehavior();
                break;
        }
    }

    public void displayHomeFragment(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment_container, homeFragment);
        transaction.commit();
    }

    private void displaySelectedBehavior() {
        SelectedBehaviorFragment selectedBehaviorFragment = new SelectedBehaviorFragment();
        Bundle args = new Bundle();
        args.putString("BehaviorName", extras.getString("SelectedBehavior"));
        args.putInt("ParentId", extras.getInt("BehaviorId"));
        selectedBehaviorFragment.setArguments(args);
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_fragment_container, selectedBehaviorFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
