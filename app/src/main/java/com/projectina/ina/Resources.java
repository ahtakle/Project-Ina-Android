package com.projectina.ina;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Resources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        ResourcesListFrag selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.all_resources:
                                selectedFragment = ResourcesListFrag.newInstance(1);
                                break;
                            case R.id.pregnancy_resources:
                                selectedFragment = ResourcesListFrag.newInstance(2);
                                break;
                            case R.id.after_birth_resources:
                                selectedFragment = ResourcesListFrag.newInstance(3);
                                break;
                            case R.id.young_child_resources:
                                selectedFragment = ResourcesListFrag.newInstance(4);
                                break;
                            case R.id.money_resources:
                                selectedFragment = ResourcesListFrag.newInstance(5);
                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_resources, selectedFragment).commit();
                        return true;
                    }
                });

        String initialDestination = getIntent().getStringExtra("GO_TO_SPECIFIC_RESOURCE");
        if(initialDestination != null) {
            PDFViewerFrag fragment = PDFViewerFrag.newInstance(initialDestination);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_resources, fragment).commit();
        } else {
            //Display the default fragment (ALL)
            ResourcesListFrag selectedFragment = ResourcesListFrag.newInstance(1);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_resources, selectedFragment).commit();
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
