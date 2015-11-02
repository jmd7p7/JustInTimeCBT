package com.jmd2479.justintimecbt;

//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import routing.HomeActivityRouter;

public class HomeActivity extends AppCompatActivity implements HomeFragment.onAppSectionListener, AddNewFragmentCreator{
    private JITDatabaseAdapter dbAdater;
    Intent intent;
    Bundle extras;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        dbAdater = new JITDatabaseAdapter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intent = getIntent();
        extras = intent.getExtras();
        if(extras==null){ //HomeActivity is being called for the first time, application just starting up
            extras = new Bundle();
            extras.putInt("HomeActivityIndex", R.string.HOME_ACTIVITY_HOME_FRAGMENT_INDEX);
        }
        HomeActivityRouter router = new HomeActivityRouter(extras, this);
        router.handleRoute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_behaviors:
                break;
            case R.id.action_get_help:
                break;
            case R.id.action_goals:
                break;
            case R.id.action_motivation:
                break;
            case R.id.action_rational_thougt:
                break;
            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    //This method is called from HomeFragment using the interface onAppSelectionListener
    //onAppSectionSelected will start a new TwoSectionActivity
    //it will pass in an index corresponding to the section of the
    //app the user wishes to navigate to
    public void onAppSectionSelected(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        AddNewFragment addNewFragment = new AddNewFragment();
        Bundle addNewFragmentArgs = new Bundle();
        switch (index){
            case R.string.BEHAVIOR_SECTION_INDEX:
                Intent intent = new Intent(this, TwoSectionActivity.class);
                intent.putExtra("TwoSectionActivityIndex", R.string.TWO_SECTION_BEHAVIOR_INDEX);
                startActivity(intent);
                break;
            case R.string.RATIONAL_THOUGHT_SECTION_INDEX:
                break;
            case R.string.MOTIVATION_SECTION_INDEX:
                break;
            case R.string.GOALS_SECTION_INDEX:
                break;
        }
    }


    @Override
    public void addAddNewFragmentToActivity() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

/*        topLayout.setVisibility(View.VISIBLE);
        transaction.add(R.id.main_fragment_container_top, new AddNewFragment());*/
        transaction.commit();
    }
}
