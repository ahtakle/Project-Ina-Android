package com.projectina.projectina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DateOptions extends AppCompatActivity {
    public static final String PREFS_NAME = "InaPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_date_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void dispatchDueDate(View view) {
        Intent intent = new Intent(this, DueDate.class);
        Bundle b = new Bundle();
        b.putInt("date_type", 1);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void dispatchBirthDate(View view) {
        Intent intent = new Intent(this, DueDate.class);
        Bundle b = new Bundle();
        b.putInt("date_type", 2);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void dispatchNoDate(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("date_type", "no_date");
        editor.apply();

        Intent intent = new Intent(this, InvalidDateProgress.class);
        startActivity(intent);
    }

}
