package com.projectina.ina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class InfoNav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    PopupWindow popUpWindow;
    LayoutInflater layoutInflater;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trimester);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_trimester);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Trimester");

        Fragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = TrimestersFrag.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("infonav error", e.toString());
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //make the background clear (the foreground therefore transparent
        try {
            drawer.getForeground().setAlpha(0);
        } catch (Exception e) {

        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

            //Change the toolbar title back to "Trimester"
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_trimester);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Trimester");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trimester, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        popUpWindow = new PopupWindow(this);


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            /*PreferenceFragment fragment = new SettingsFrag();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            //Change toolbar title to "Settings"
            getSupportActionBar().setTitle("Settings"); */

            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

            return true;
        } else if (id == R.id.action_about_me) {
            /*android.support.v4.app.Fragment fragment = null;
            Class fragmentClass = null;
            fragmentClass = AboutMeFrag.class;
            try {
                fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("glossary error", e.toString());
            }
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit(); */

            //Change toolbar title to "About Me"
            getSupportActionBar().setTitle("About Me");

            Intent intent = new Intent(this, AboutMeActivity.class);
            startActivity(intent);

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.action_help) {
            /*android.support.v4.app.Fragment fragment = null;
            Class fragmentClass = null;
            fragmentClass = HelpFrag.class;
            try {
                fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("help error", e.toString());
            }
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit(); */

            //Change toolbar title to "Help"
            getSupportActionBar().setTitle("Help");

            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.action_feedback) {
            /*android.support.v4.app.Fragment fragment = null;
            Class fragmentClass = null;
            fragmentClass = FeedbackFrag.class;
            try {
                fragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("help error", e.toString());
            }
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();*/

            //Change toolbar title to "Feedback"
            getSupportActionBar().setTitle("Feedback");

            Intent intent = new Intent(this, FeedbackActivity.class);
            startActivity(intent);

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.action_resources) {
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.fragment_resource_pop_up, null);
            popUpWindow = new PopupWindow(container, drawer.getWidth() * 2 / 3, drawer.getHeight() / 3, true);
            popUpWindow.showAtLocation(drawer, Gravity.CENTER, 0, 0);
            try {
                drawer.getForeground().setAlpha(125);
            } catch (Exception e) {

            }

            popUpWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    try {
                        drawer.getForeground().setAlpha(0);
                    } catch (Exception e) {

                    }
                }
            });


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.nav_camera) {
            fragmentClass = TrimestersFrag.class;
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
