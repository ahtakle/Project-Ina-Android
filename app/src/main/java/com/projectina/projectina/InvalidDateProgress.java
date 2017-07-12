package com.projectina.projectina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class InvalidDateProgress extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalid_date_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String date_type = settings.getString("date_type", "");

        TextView textView = (TextView) findViewById(R.id.invalid_date_txt);
        String text = "";

        if (date_type.equals("invalid_due_date")) {
            //Invalid due date
            text = getText(R.string.invalid_due_date).toString();
        } else if (date_type.equals("invalid_birth_date")) {
            //Invalid birth date
            text = getText(R.string.invalid_birth_date).toString();
        } else {
            //No due date
            text = getText(R.string.no_due_date_txt).toString();
        }

        textView.setText(text);

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
