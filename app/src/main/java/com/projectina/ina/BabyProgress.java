package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class BabyProgress extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String due_date_str = settings.getString("date", "");
        int due_year = Integer.parseInt(settings.getString("year", ""));
        int due_month = Integer.parseInt(settings.getString("month", ""));
        int due_day = Integer.parseInt(settings.getString("day", ""));

        if (due_date_str.equalsIgnoreCase("not selected")) {
        } else {

            //Get current date
            java.util.Calendar mcurrentDate = java.util.Calendar.getInstance();
            int mYear = mcurrentDate.get(java.util.Calendar.YEAR);
            int mMonth = mcurrentDate.get(java.util.Calendar.MONTH);
            int mDay = mcurrentDate.get(java.util.Calendar.DAY_OF_MONTH);

            //Calculate time until due date and display on progress bar
            Date currDate = new Date(mYear, mMonth, mDay);
            Date dueDate = new Date(due_year, due_month, due_day);
            final int millisInDay = 1000 * 60 * 60 * 24;
            int diffInDays = (int) ((currDate.getTime() - dueDate.getTime()) / millisInDay);

            //Calculate and display percent done
            //TextView percentDoneText = (TextView) findViewById(R.id.percent_done);
            //percentDoneText.setText("You are " + percentDone + "% done");

            //Display 'subtitles' to the right of the image
            int monthsCompleted = diffInDays / 30;
            int weeksCompleted = (diffInDays % 30 + 1) / 7;
            TextView weekDaySubtitle = (TextView) findViewById(R.id.week_day_subtitle);
            weekDaySubtitle.setText("Month " + monthsCompleted + ", Week " + weeksCompleted);
            TextView trimSubtitle = (TextView) findViewById(R.id.trim_subtitle);
            TextView dueDateSubtitle = (TextView) findViewById(R.id.due_date_subtitle);
            dueDateSubtitle.setText("Baby\'s Birth Date: " + due_date_str);

            //Calculate and display weekly information
            TextView monthTitle = (TextView) findViewById(R.id.progress_weeks_title);
            TextView monthInfo = (TextView) findViewById(R.id.progress_weeks_info);
            String[] monthlyInfo = getResources().getStringArray(R.array.monthly_info);
            monthTitle.setText("Month " + monthsCompleted + " Facts");
            monthInfo.setText(monthlyInfo[monthsCompleted - 1]);

        }

    }

    //Change/Remove Date
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
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
