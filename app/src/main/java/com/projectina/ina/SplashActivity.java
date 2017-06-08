package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/*
*  Splash Activity that leads to Home activity while app loads
*/

public class SplashActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        //if (settings.getString("due_date", "") == null || settings.getString("due_date","") == ""){
        if (settings.getString("due_date", "").length() == 0) {
            //Intent intent = new Intent(this, DueDate.class);
            Intent intent = new Intent(this, DateOptions.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }
    }
}
