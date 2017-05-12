package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.projectina.ina.GlossaryFragments.TeenFrag.PREFS_NAME;

/*
*  Splash Activity that leads to Home activity while app loads
*/

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getString("due_date", "") == null || settings.getString("due_date","") == ""){
            Intent intent = new Intent(this, DueDate.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
            finish();
        }
    }
}
