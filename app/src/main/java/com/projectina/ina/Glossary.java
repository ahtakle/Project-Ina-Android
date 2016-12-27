package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 */

import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Glossary extends AppCompatActivity implements OnFragmentInteractionListener {
    private List<GlossaryTerm> glossaryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GlossaryAdapter mAdapter;

    RelativeLayout glossaryView;
    PopupWindow popUpWindow;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
        //Log.d("content", getCurrentFocus().toString());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_trimester); //same toolbar for now
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new GlossaryAdapter(glossaryList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //This is to add the dividers in the list
        recyclerView.addItemDecoration(new GlossaryTermDivider(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        //When a glossary term gets clicked!
        recyclerView.addOnItemTouchListener(new GlossaryTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                GlossaryTerm term = glossaryList.get(position);
                Toast.makeText(getApplicationContext(), term.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        glossaryView = (RelativeLayout) findViewById(R.id.glossary_view);
        //make the background clear (the foreground therefore transparent
        try {
            glossaryView.getForeground().setAlpha(0);
        } catch (Exception e) {

        }

        prepareGlossaryData();
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

        popUpWindow = new PopupWindow(this);


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            PreferenceFragment fragment = new SettingsFrag();
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flContent, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            //Change toolbar title to "Settings"
            getSupportActionBar().setTitle("Settings");

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            //drawer.closeDrawer(GravityCompat.START);

            return true;
        } else if (id == R.id.action_about_me) {
            android.support.v4.app.Fragment fragment = null;
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
            fragmentTransaction.commit();

            //Change toolbar title to "About Me"
            getSupportActionBar().setTitle("About Me");

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            //drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.action_help) {
            android.support.v4.app.Fragment fragment = null;
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
            fragmentTransaction.commit();

            //Change toolbar title to "Help"
            getSupportActionBar().setTitle("Help");

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            //drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.action_feedback) {
            android.support.v4.app.Fragment fragment = null;
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
            fragmentTransaction.commit();

            //Change toolbar title to "Feedback"
            getSupportActionBar().setTitle("Feedback");

            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            //drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.action_resources) {
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.fragment_resource_pop_up, null);

            popUpWindow = new PopupWindow(container, glossaryView.getWidth() * 2 / 3, glossaryView.getHeight() / 3, true);
            popUpWindow.showAtLocation(glossaryView, Gravity.CENTER, 0, 0);
            try {
                glossaryView.getForeground().setAlpha(125);
            } catch (Exception e) {

            }

            popUpWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    try {
                        glossaryView.getForeground().setAlpha(0);
                    } catch (Exception e) {

                    }
                }
            });


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //Change the toolbar title back to "Glossary"
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_trimester); //Same toolbar for now...?
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Glossary");

    }

    private void prepareGlossaryData() {
        GlossaryTerm term = new GlossaryTerm("Mad Max: Fury Road", "Action & Adventure", "2015");
        glossaryList.add(term);

        GlossaryTerm term2 = new GlossaryTerm("Inside Out", "Animation, Kids & Family", "2015");
        glossaryList.add(term2);

        GlossaryTerm term3 = new GlossaryTerm("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        glossaryList.add(term3);

        GlossaryTerm term4 = new GlossaryTerm("Shaun the Sheep", "Animation", "2015");
        glossaryList.add(term4);

        GlossaryTerm term5 = new GlossaryTerm("The Martian", "Science Fiction & Fantasy", "2015");
        glossaryList.add(term5);

        GlossaryTerm term6 = new GlossaryTerm("Mission: Impossible Rogue Nation", "Action", "2015");
        glossaryList.add(term6);

        GlossaryTerm term7 = new GlossaryTerm("Up", "Animation", "2009");
        glossaryList.add(term7);

        GlossaryTerm term8 = new GlossaryTerm("Star Trek", "Science Fiction", "2009");
        glossaryList.add(term8);

        GlossaryTerm term9 = new GlossaryTerm("The LEGO GlossaryTerm", "Animation", "2014");
        glossaryList.add(term9);

        GlossaryTerm term10 = new GlossaryTerm("Iron Man", "Action & Adventure", "2008");
        glossaryList.add(term10);

        GlossaryTerm term11 = new GlossaryTerm("Aliens", "Science Fiction", "1986");
        glossaryList.add(term11);

        GlossaryTerm term12 = new GlossaryTerm("Chicken Run", "Animation", "2000");
        glossaryList.add(term12);

        GlossaryTerm term13 = new GlossaryTerm("Back to the Future", "Science Fiction", "1985");
        glossaryList.add(term13);

        GlossaryTerm term14 = new GlossaryTerm("Raiders of the Lost Ark", "Action & Adventure", "1981");
        glossaryList.add(term14);

        GlossaryTerm term15 = new GlossaryTerm("Goldfinger", "Action & Adventure", "1965");
        glossaryList.add(term15);

        GlossaryTerm term16 = new GlossaryTerm("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        glossaryList.add(term16);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
