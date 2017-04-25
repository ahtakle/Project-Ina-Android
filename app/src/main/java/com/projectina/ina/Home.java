package com.projectina.ina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
