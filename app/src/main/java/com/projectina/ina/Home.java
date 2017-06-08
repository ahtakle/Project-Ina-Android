package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Home extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";
    public static SharedPreferences settings;

//    public static final String PREFS_NAME = "InaPrefsFile";
//
//    private TextView due_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//        String due_date_str = settings.getString("due_date", "");
//
//        due_date = (TextView) findViewById(R.id.due_date_title);
//        due_date.setText("Due Date: " + due_date_str);

    }


    //Start Map Activity
    public void dispatchMapIntent(View view) {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    // Start Resources Activity
    public void dispatchResourcesIntent(View view) {
        Intent intent = new Intent(this, Resources.class);
        startActivity(intent);
    }

    //Start Glossary Activity
    public void dispatchGlossaryIntent(View view) {
        Intent intent = new Intent(this, Glossary.class);
        startActivity(intent);
    }

    //Start Calendar Activity
    public void dispatchCalendarIntent(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

    //Start BabyProgress Activity
    public void dispatchBabyProgressIntent(View view) {
        settings = getSharedPreferences(PREFS_NAME, 0);
        //String due_date_str = settings.getString("date", "");
        Intent intent;
        String data_type = settings.getString("date_type", "");
        //Log.d("data type", data_type);
        if (data_type.equals("due_date"))
            intent = new Intent(this, PregnancyProgress.class);
        else if (data_type.equals("birth_date"))
            intent = new Intent(this, BabyProgress.class);
        else
            intent = new Intent(this, NoDueDateProgress.class);
        /*if (due_date_str.equalsIgnoreCase("not selected")) {
            intent = new Intent(this, NoDueDateProgress.class);
        } else {
            intent = new Intent(this, BabyProgress.class);
        }*/
        startActivity(intent);
    }

    //Start Stories Activity
    public void dispatchStoriesIntent(View view) {
        Intent intent = new Intent(this, Stories.class);
        startActivity(intent);
    }


}
