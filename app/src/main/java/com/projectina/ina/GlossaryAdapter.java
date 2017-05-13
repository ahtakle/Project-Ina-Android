package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 * Basic RecyclerView Adapter needed to set up the recyclerview
 */


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectina.ina.GlossaryFragments.AlcoholFrag;
import com.projectina.ina.GlossaryFragments.BreastfeedingFrag;
import com.projectina.ina.GlossaryFragments.ComplicationsFrag;
import com.projectina.ina.GlossaryFragments.DeliveryFrag;
import com.projectina.ina.GlossaryFragments.FamilyPlanningFrag;
import com.projectina.ina.GlossaryFragments.FetalDevelopmentFrag;
import com.projectina.ina.GlossaryFragments.HealthyDietFrag;
import com.projectina.ina.GlossaryFragments.HealthyRelationshipsFrag;
import com.projectina.ina.GlossaryFragments.MedsFrag;
import com.projectina.ina.GlossaryFragments.MentalHealthFrag;
import com.projectina.ina.GlossaryFragments.NextStepsFrag;
import com.projectina.ina.GlossaryFragments.PreConceptionFrag;
import com.projectina.ina.GlossaryFragments.PrenatalFrag;
import com.projectina.ina.GlossaryFragments.SecondhandSmokeFrag;
import com.projectina.ina.GlossaryFragments.SubstanceAbuseFrag;
import com.projectina.ina.GlossaryFragments.TeenFrag;
import com.projectina.ina.GlossaryFragments.ViolenceFrag;

import java.util.List;

public class GlossaryAdapter extends RecyclerView.Adapter<GlossaryAdapter.MyViewHolder> {

    private List<GlossaryTerm> glossaryList;
    private android.support.v4.app.FragmentManager fragmentManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public GlossaryAdapter(List<GlossaryTerm> glossaryList, android.support.v4.app.FragmentManager fragManager) {
        this.glossaryList = glossaryList;
        fragmentManager = fragManager;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.glossary_term_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        GlossaryTerm term = glossaryList.get(position);
        holder.title.setText(term.getTitle());
        holder.genre.setText(term.getGenre());
        holder.year.setText(term.getYear());

        //int textColor = R.color.colorText;
        holder.title.setTextColor(term.getColor());


        //add onclicklistener here to update the fragment manager based on position

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("onclicklistener", "something was clicked!");
                GlossaryTerm term2 = glossaryList.get(position);
                holder.title.setText(term2.getTitle());

                Fragment fragment = new Fragment();
                if (term2.getTitle().equals("Family Planning")) {
                    fragment = new FamilyPlanningFrag();
                } else if (term2.getTitle().equals("Healthy Diet")) {
                    fragment = new HealthyDietFrag();
                } else if (term2.getTitle().equals("Healthy Relationships")) {
                    fragment = new HealthyRelationshipsFrag();
                } else if (term2.getTitle().equals("Fetal Development")) {
                    fragment = new FetalDevelopmentFrag();
                } else if (term2.getTitle().equals("Substance Abuse During Pregnancy")) {
                    fragment = new SubstanceAbuseFrag();
                } else if (term2.getTitle().equals("Mental Health Issues During and After Pregnancy")) {
                    fragment = new MentalHealthFrag();
                } else if (term2.getTitle().equals("Medications and Supplements Considered Safe During Pregnancy")) {
                    fragment = new MedsFrag();
                } else if (term2.getTitle().equals("Teen Pregnancy")) {
                    fragment = new TeenFrag();
                } else if (term2.getTitle().equals("Pre-Conception Health")) {
                    fragment = new PreConceptionFrag();
                } else if (term2.getTitle().equals("Breastfeeding")) {
                    fragment = new BreastfeedingFrag();
                } else if (term2.getTitle().equals("Prenatal Medical Procedures")) {
                    fragment = new PrenatalFrag();
                } else if (term2.getTitle().equals("Preparation for Delivery")) {
                    fragment = new DeliveryFrag();
                } else if (term2.getTitle().equals("Pregnancy Complications")) {
                    fragment = new ComplicationsFrag();
                } else if (term2.getTitle().equals("Next Steps")) {
                    fragment = new NextStepsFrag();
                } else if (term2.getTitle().equals("Domestic Violence and Sexual Assault")) {
                    fragment = new ViolenceFrag();
                } else if (term2.getTitle().equals("Alcohol")) {
                    fragment = new AlcoholFrag();
                } else if (term2.getTitle().equals("Secondhand Smoke")) {
                    fragment = new SecondhandSmokeFrag();
                }

                //Log.d("change fragment", " to " + term2.getTitle());
                fragmentManager.beginTransaction()
                        .replace(R.id.glossary_frame_layout, fragment).addToBackStack(null).commit();
            }
        });
        /**/

    }

    @Override
    public int getItemCount() {
        return glossaryList.size();
    }
}
