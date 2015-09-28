package com.jmd2479.justintimecbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddBehaviorActivity extends AppCompatActivity {
    Button createBehaviorButton;
    JITDatabaseAdapter dbAdapter;

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText newBehaviorName = (EditText)AddBehaviorActivity.this.findViewById(R.id.addBehaviorEditText);
            dbAdapter = new JITDatabaseAdapter(AddBehaviorActivity.this);
            long result = dbAdapter.insertBehavior(newBehaviorName.getText().toString());
            if(result < 0){
                Toast.makeText(AddBehaviorActivity.this, "could not add new behavior", Toast.LENGTH_LONG);
            }
            Intent intent = new Intent(AddBehaviorActivity.this, BehaviorActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_behavior);

        createBehaviorButton = (Button) findViewById(R.id.createNewBehavior);
        createBehaviorButton.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_behavior, menu);
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
}
