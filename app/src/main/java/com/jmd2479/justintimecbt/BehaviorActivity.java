package com.jmd2479.justintimecbt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BehaviorActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    JITDatabaseAdapter dbAdapter;
    ListView behaviorLV;
    Button addBehaviorBtn;
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(BehaviorActivity.this, AddBehaviorActivity.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        behaviorLV = (ListView) findViewById(R.id.behaviorListView);

        dbAdapter = new JITDatabaseAdapter(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dbAdapter.getBehaviors());
        behaviorLV.setAdapter(adapter);
        behaviorLV.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        addBehaviorBtn = (Button) findViewById(R.id.addBehaviorBtn);
        addBehaviorBtn.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_behavior, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView selectedView = (TextView) view;
        String behavior = (String) selectedView.getText();

        Intent intent = new Intent(this, SingleBehaviorActivity.class);
        intent.putExtra(getString(R.string.SelectedBehavior), behavior);
        startActivity(intent);
    }
}