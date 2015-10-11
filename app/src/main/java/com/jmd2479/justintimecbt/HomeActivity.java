package com.jmd2479.justintimecbt;

//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity implements HomeFragment.onAppSectionListener, BehaviorListFragment.onBehaviorSelectedListener{
    JITDatabaseAdapter dbAdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbAdater = new JITDatabaseAdapter(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FrameLayout topLayout = (FrameLayout) findViewById (R.id.main_fragment_container_top);
        topLayout.setVisibility(View.GONE);
        FrameLayout bottomLayout = (FrameLayout) findViewById (R.id.main_fragment_container_bottom);
        bottomLayout.setVisibility(View.GONE);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment_container, homeFragment);
        transaction.commit();

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
    public void onAppSectionSelected(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (index){
            case 0:
                transaction.replace(R.id.main_fragment_container, new BehaviorListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 1:
                NewBehaviorDialogFragment nbdf = new NewBehaviorDialogFragment();
                FragmentManager fmm = getSupportFragmentManager();
                nbdf.show(fmm, "NewBehavior!");
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    @Override
    public void onBehaviorSelected(int id, String behavior) {
        SelectedBehaviorFragment selectedBehaviorFragment = new SelectedBehaviorFragment();
        Bundle args = new Bundle();
        args.putString("BehaviorName", behavior);
        args.putInt("BehaviorId", id);
        selectedBehaviorFragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_fragment_container, selectedBehaviorFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
