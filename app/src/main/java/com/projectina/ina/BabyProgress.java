package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BabyProgress extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";
    private ProgressBar progressBar = null;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String due_date_str = settings.getString("due_date", "");
        int due_year = Integer.parseInt(settings.getString("due_year", ""));
        int due_month = Integer.parseInt(settings.getString("due_month", ""));
        int due_day = Integer.parseInt(settings.getString("due_day", ""));

        if (due_date_str.equalsIgnoreCase("not selected")) {

        } else {
            progressBar = (ProgressBar) findViewById(R.id.progressBar2);
            progressBar.setVisibility(View.VISIBLE);

            //Average length of pregnancy is 280 days
            final int pregnancyLength = 280;
            progressBar.setMax(pregnancyLength);

            //Get current date
            java.util.Calendar mcurrentDate = java.util.Calendar.getInstance();
            int mYear = mcurrentDate.get(java.util.Calendar.YEAR);
            int mMonth = mcurrentDate.get(java.util.Calendar.MONTH);
            int mDay = mcurrentDate.get(java.util.Calendar.DAY_OF_MONTH);

            //Calculate time until due date
            Date currDate = new Date(mYear, mMonth, mDay);
            Date dueDate = new Date(due_year, due_month, due_day);
            final int millisInDay = 1000 * 60 * 60 * 24;
            int diffInDays = (int) ((dueDate.getTime() - currDate.getTime()) / millisInDay);
            Log.e("difference in days", diffInDays + "");


            progressBar.setProgress(pregnancyLength - diffInDays);


            TextView weekText = (TextView) findViewById(R.id.progress_weeks);
            int weeksCompleted = (pregnancyLength - diffInDays) / 7;
            weekText.setText("You are in week " + weeksCompleted + "!\n");

            TextView trimText = (TextView) findViewById(R.id.trimester);
            if (weeksCompleted <= 12)
                trimText.setText("Trimester 1");
            else if (weeksCompleted <= 28)
                trimText.setText("Trimester 2");
            else
                trimText.setText("Trimester 3");

            expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
            expandableListDetail = TrimListDataPump.getData();
            expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
            expandableListAdapter = new TrimListAdapter(this, expandableListTitle, expandableListDetail);
            expandableListView.setAdapter(expandableListAdapter);
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                    Toast.makeText(getApplicationContext(),
                            expandableListTitle.get(groupPosition) + " List Expanded.",
                            Toast.LENGTH_SHORT).show();
                }
            });

            expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    Toast.makeText(getApplicationContext(),
                            expandableListTitle.get(groupPosition) + " List Collapsed.",
                            Toast.LENGTH_SHORT).show();

                }
            });

            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    Toast.makeText(
                            getApplicationContext(),
                            expandableListTitle.get(groupPosition)
                                    + " -> "
                                    + expandableListDetail.get(
                                    expandableListTitle.get(groupPosition)).get(
                                    childPosition), Toast.LENGTH_SHORT
                    ).show();
                    return false;
                }
            });

        }

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

        if (id == R.id.action_settings) {
            //TODO: Make settings activity... but what do we have??
            //Intent intent = new Intent(this, SettingsActivity.class);
            //startActivity(intent);
            return true;
        } else if (id == R.id.action_about_me) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_help) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_resources) {
            //TODO: Come up with some contact info thing.
            //Note: Aditi has some good code on her original branch for this :)
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
