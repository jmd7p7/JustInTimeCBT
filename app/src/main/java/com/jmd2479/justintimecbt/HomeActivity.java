package com.jmd2479.justintimecbt;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements HomeFragment.onAppSectionListener {
    JITDatabaseAdapter dbAdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbAdater = new JITDatabaseAdapter(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        HomeFragment homeFragment = new HomeFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
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
        switch (index){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
