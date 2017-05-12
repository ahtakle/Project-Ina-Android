package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.projectina.ina.GlossaryFragments.TeenFrag.PREFS_NAME;


public class Home extends AppCompatActivity {

    private TextView due_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String due_date_str = settings.getString("due_date", "");

        due_date = (TextView) findViewById(R.id.due_date_title);
        due_date.setText("Due Date: " + due_date_str);

    }

    //Start BackgroundIntro Activity
    public void dispatchBackgroundIntent(View view) {
        Intent intent = new Intent(this, BackgroundIntro.class);
        startActivity(intent);
    }

    //Start MapFragHostActivity Activity
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


}
