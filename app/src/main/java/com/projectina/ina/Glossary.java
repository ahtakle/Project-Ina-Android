package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 * Glossary activity.
 * Uses a recyclerView activity with a clickListener
 * TODO: a fragment manager to change to new activity and parse which fragment to go to as well
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Glossary extends AppCompatActivity {
    private List<GlossaryTerm> glossaryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GlossaryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Glossary");

        //Following lines of code are where we prepare the recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new GlossaryAdapter(this, getSupportFragmentManager(), glossaryList);
        //mAdapter = new GlossaryAdapter(glossaryList, getSupportFragmentManager());
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //This is to add the dividers in the list
        recyclerView.addItemDecoration(new GlossaryTermDivider(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            setTitle("Glossary");
        }
        return super.onKeyDown(keyCode, event);
    }


    //Here is where we prepare the Glossary Data
    private void prepareGlossaryData() {
        GlossaryTerm term10 = new GlossaryTerm("Teen Pregnancy", "", "");
        glossaryList.add(term10);

        GlossaryTerm term11 = new GlossaryTerm("Pre-Conception Health", "", "");
        glossaryList.add(term11);

        GlossaryTerm term = new GlossaryTerm("Family Planning", "", ""); //
        glossaryList.add(term);

        GlossaryTerm term2 = new GlossaryTerm("Healthy Diet", "", "");
        glossaryList.add(term2);

        GlossaryTerm term3 = new GlossaryTerm("Healthy Relationships", "", "");
        glossaryList.add(term3);

        GlossaryTerm term4 = new GlossaryTerm("Domestic Violence and Sexual Assault", "", "");
        glossaryList.add(term4);

        GlossaryTerm term5 = new GlossaryTerm("Next Steps", "", "");
        glossaryList.add(term5);

        GlossaryTerm term6 = new GlossaryTerm("Substance Abuse During Pregnancy", "", "");
        glossaryList.add(term6);

        GlossaryTerm term17 = new GlossaryTerm("Alcohol", "", "");
        glossaryList.add(term17);

        GlossaryTerm term7 = new GlossaryTerm("Mental Health Issues During and After Pregnancy", "", "");
        glossaryList.add(term7);

        GlossaryTerm term8 = new GlossaryTerm("Medications and Supplements Considered Safe During Pregnancy", "", "");
        glossaryList.add(term8);

        GlossaryTerm term9 = new GlossaryTerm("Fetal Development", "", "");
        glossaryList.add(term9);

        GlossaryTerm term12 = new GlossaryTerm("Breastfeeding", "", "");
        glossaryList.add(term12);

        GlossaryTerm term13 = new GlossaryTerm("Prenatal Medical Procedures", "", ""); //
        glossaryList.add(term13);

        GlossaryTerm term14 = new GlossaryTerm("Preparation for Delivery", "", ""); //
        glossaryList.add(term14);

        GlossaryTerm term15 = new GlossaryTerm("Pregnancy Complications", "", ""); //
        glossaryList.add(term15);

        GlossaryTerm term16 = new GlossaryTerm("Secondhand Smoke", "", ""); //
        glossaryList.add(term16);

        mAdapter.notifyDataSetChanged();
    }
}