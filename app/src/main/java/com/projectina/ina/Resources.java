package com.projectina.ina;

import android.content.Intent;
import android.os.Bundle;
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

        ResourcesListFrag f = ResourcesListFrag.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_resources, f).commit();


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

//    private View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(final View v) {
//
//            Fragment fragment = new Fragment();
//            switch (v.getId()) {
//                case R.id.buttonCoteau:
//                    fragment = new CoteauFrag();
//                    break;
//                case R.id.buttonGPTCHB:
//                    fragment = new GPTCHBFrag();
//                    break;
//                case R.id.buttonNESD:
//                    fragment = new NESDFrag();
//                    break;
//                case R.id.buttonRoberts:
//                    fragment = new RobertsCountyFrag();
//                    break;
//                case R.id.buttonSDBreastfeeding:
//                    fragment = new SDBreastfeedingFrag();
//                    break;
//                case R.id.buttonSDHomeVisiting:
//                    fragment = new SDHomeVisitingFrag();
//                    break;
//                case R.id.buttonSDSocial:
//                    fragment = new SDSocialFrag();
//                    break;
//                case R.id.buttonSissetonClinic:
//                    fragment = new SissetonClinicFrag();
//                    break;
//                case R.id.buttonSissetonDental:
//                    fragment = new SissetonDentalFrag();
//                    break;
//                case R.id.buttonSissetonNurse:
//                    fragment = new SissetonNurseFrag();
//                    break;
//                case R.id.buttonSissetonSchool:
//                    fragment = new SissetonSchoolFrag();
//                    break;
//                case R.id.buttonSWOBenefits:
//                    fragment = new SWOBenefitsFrag();
//                    break;
//                case R.id.buttonSWOCavity:
//                    fragment = new SWOCavityFrag();
//                    break;
//                case R.id.buttonSWOChild:
//                    fragment = new SWOChildFrag();
//                    break;
//                case R.id.buttonSWOHealthEd:
//                    fragment = new SWOHealthEdFrag();
//                    break;
//                case R.id.buttonSWOHealthRep:
//                    fragment = new SWOHealthRepFrag();
//                    break;
//                case R.id.buttonSWOPride:
//                    fragment = new SWOPrideFrag();
//                    break;
//                case R.id.buttonSWOIntervention:
//                    fragment = new SWOInterventionFrag();
//                    break;
//                case R.id.buttonSWOEducation:
//                    fragment = new SWOEducationFrag();
//                    break;
//                case R.id.buttonSWOFood:
//                    fragment = new SWOFoodFrag();
//                    break;
//                case R.id.buttonSWOEHS:
//                    fragment = new SWOEHSFrag();
//                    break;
//                case R.id.buttonSWODaycare:
//                    fragment = new SWODaycareFrag();
//                    break;
//                case R.id.buttonSWOMCH:
//                    fragment = new SWOMCHFrag();
//                    break;
//                case R.id.buttonFinances:
//                    fragment = new FinancesFrag();
//                    break;
//
//            }
//
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.content_resources, fragment).addToBackStack("")
//                    .commit();
//        }
//    };

}
