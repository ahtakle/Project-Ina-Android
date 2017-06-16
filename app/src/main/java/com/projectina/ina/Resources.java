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
                        CardListFrag selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.all_resources:
                                selectedFragment = CardListFrag.newInstance(1, 1);
                                break;
                            case R.id.pregnancy_resources:
                                selectedFragment = CardListFrag.newInstance(1, 2);
                                break;
                            case R.id.after_birth_resources:
                                selectedFragment = CardListFrag.newInstance(1, 3);
                                break;
                            case R.id.young_child_resources:
                                selectedFragment = CardListFrag.newInstance(1, 4);
                                break;
                            case R.id.money_resources:
                                selectedFragment = CardListFrag.newInstance(1, 5);
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
            CardListFrag selectedFragment = CardListFrag.newInstance(1, 1);
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

        if (id == android.R.id.home) {
            // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
            // if this doesn't work as desired, another possibility is to call `finish()` here.
            this.onBackPressed();
            return true;
        } else if (id == R.id.action_about_me) {
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
