package com.projectina.ina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.projectina.ina.ResourceFragments.CoteauFrag;
import com.projectina.ina.ResourceFragments.FinancesFrag;
import com.projectina.ina.ResourceFragments.GPTCHBFrag;
import com.projectina.ina.ResourceFragments.NESDFrag;
import com.projectina.ina.ResourceFragments.RobertsCountyFrag;
import com.projectina.ina.ResourceFragments.SDBreastfeedingFrag;
import com.projectina.ina.ResourceFragments.SDHomeVisitingFrag;
import com.projectina.ina.ResourceFragments.SDSocialFrag;
import com.projectina.ina.ResourceFragments.SWOBenefitsFrag;
import com.projectina.ina.ResourceFragments.SWOCavityFrag;
import com.projectina.ina.ResourceFragments.SWOChildFrag;
import com.projectina.ina.ResourceFragments.SWODaycareFrag;
import com.projectina.ina.ResourceFragments.SWOEHSFrag;
import com.projectina.ina.ResourceFragments.SWOEducationFrag;
import com.projectina.ina.ResourceFragments.SWOFoodFrag;
import com.projectina.ina.ResourceFragments.SWOHealthEdFrag;
import com.projectina.ina.ResourceFragments.SWOHealthRepFrag;
import com.projectina.ina.ResourceFragments.SWOInterventionFrag;
import com.projectina.ina.ResourceFragments.SWOMCHFrag;
import com.projectina.ina.ResourceFragments.SWOPrideFrag;
import com.projectina.ina.ResourceFragments.SissetonClinicFrag;
import com.projectina.ina.ResourceFragments.SissetonDentalFrag;
import com.projectina.ina.ResourceFragments.SissetonNurseFrag;
import com.projectina.ina.ResourceFragments.SissetonSchoolFrag;

import java.util.ArrayList;
import java.util.List;

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



//        Button button1 = (Button) findViewById(R.id.buttonCoteau);
//        button1.setOnClickListener(onClickListener);
//
//        Button button2 = (Button) findViewById(R.id.buttonGPTCHB);
//        button2.setOnClickListener(onClickListener);
//
//        Button button3 = (Button) findViewById(R.id.buttonMidwest);
//        button3.setOnClickListener(onClickListener);
//
//        Button button4 = (Button) findViewById(R.id.buttonNESD);
//        button4.setOnClickListener(onClickListener);
//
//        Button button5 = (Button) findViewById(R.id.buttonRoberts);
//        button5.setOnClickListener(onClickListener);
//
//        Button button6 = (Button) findViewById(R.id.buttonSDBreastfeeding);
//        button6.setOnClickListener(onClickListener);
//
//        Button button7 = (Button) findViewById(R.id.buttonSDHomeVisiting);
//        button7.setOnClickListener(onClickListener);
//
//        Button button8 = (Button) findViewById(R.id.buttonSDSocial);
//        button8.setOnClickListener(onClickListener);
//
//        Button button9 = (Button) findViewById(R.id.buttonSissetonClinic);
//        button9.setOnClickListener(onClickListener);
//
//        Button button10 = (Button) findViewById(R.id.buttonSissetonDental);
//        button10.setOnClickListener(onClickListener);
//
//        Button button11 = (Button) findViewById(R.id.buttonSissetonNurse);
//        button11.setOnClickListener(onClickListener);
//
//        Button button12 = (Button) findViewById(R.id.buttonSissetonSchool);
//        button12.setOnClickListener(onClickListener);
//
//        Button button13 = (Button) findViewById(R.id.buttonSWOBenefits);
//        button13.setOnClickListener(onClickListener);
//
//        Button button14 = (Button) findViewById(R.id.buttonSWOCavity);
//        button14.setOnClickListener(onClickListener);
//
//        Button button15 = (Button) findViewById(R.id.buttonSWOChild);
//        button15.setOnClickListener(onClickListener);
//
//        Button button16 = (Button) findViewById(R.id.buttonSWOHealthEd);
//        button16.setOnClickListener(onClickListener);
//
//        Button button17 = (Button) findViewById(R.id.buttonSWOHealthRep);
//        button17.setOnClickListener(onClickListener);
//
//        Button button18 = (Button) findViewById(R.id.buttonSWOPride);
//        button18.setOnClickListener(onClickListener);
//
//        Button button19 = (Button) findViewById(R.id.buttonSWOIntervention);
//        button19.setOnClickListener(onClickListener);
//
//        Button button20 = (Button) findViewById(R.id.buttonSWOEducation);
//        button20.setOnClickListener(onClickListener);
//
//        Button button21 = (Button) findViewById(R.id.buttonSWOFood);
//        button21.setOnClickListener(onClickListener);
//
//        Button button22 = (Button) findViewById(R.id.buttonSWOEHS);
//        button22.setOnClickListener(onClickListener);
//
//        Button button23 = (Button) findViewById(R.id.buttonSWODaycare);
//        button23.setOnClickListener(onClickListener);
//
//        Button button24 = (Button) findViewById(R.id.buttonSWOMCH);
//        button24.setOnClickListener(onClickListener);
//
//        Button button25 = (Button) findViewById(R.id.buttonFinances);
//        button25.setOnClickListener(onClickListener);


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
