package com.projectina.projectina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NoDueDateProgress extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_due_date_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //Change/Remove Due Date
    public void dispatchDueDate(View view) {
        Intent intent = new Intent(this, DateOptions.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //popUpWindow = new PopupWindow(this);

        if (id == R.id.action_about_me) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_tutorial) {
            /*Intent intent = new Intent(this, Help.class);
            startActivity(intent);*/
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
