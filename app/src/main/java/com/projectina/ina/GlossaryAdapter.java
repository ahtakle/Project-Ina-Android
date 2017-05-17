package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 * Basic RecyclerView Adapter needed to set up the recyclerview
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GlossaryAdapter extends RecyclerView.Adapter<GlossaryAdapter.ViewHolder> {

    private List<GlossaryTerm> glossaryList;
    private android.support.v4.app.FragmentManager mFragmentManager;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

    // Store the context for easy access
    public Context mContext;


    // Pass in the contact array into the constructor
    public GlossaryAdapter(Context context, FragmentManager fragmentManager, List<GlossaryTerm> list) {
        glossaryList = list;
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

//    public GlossaryAdapter(List<GlossaryTerm> glossaryList, android.support.v4.app.FragmentManager fragManager) {
//        this.glossaryList = glossaryList;
//        fragmentManager = fragManager;
//    }

//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.glossary_term_row, parent, false);
//
//        return new MyViewHolder(itemView);
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        final View contactView = inflater.inflate(R.layout.glossary_term_row, parent, false);
        //Holder instance to be returned
        final ViewHolder viewHolder = new ViewHolder(contactView);


        contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final int position = viewHolder.getAdapterPosition();
                //add onclicklistener here to update the fragment manager based on position

                GlossaryTerm term2 = glossaryList.get(position);


                //Fragment fragment = null;//new Fragment();
//                if (term2.getTitle().equals("Family Planning")) {
//                    fragment = new FamilyPlanningFrag();
//                } else if (term2.getTitle().equals("Healthy Diet")) {
//                    fragment = new HealthyDietFrag();
//                } else if (term2.getTitle().equals("Healthy Relationships")) {
//                    fragment = new HealthyRelationshipsFrag();
//                } else if (term2.getTitle().equals("Fetal Development")) {
//                    fragment = new FetalDevelopmentFrag();
//                } else if (term2.getTitle().equals("Substance Abuse During Pregnancy")) {
//                    fragment = new SubstanceAbuseFrag();
//                } else if (term2.getTitle().equals("Mental Health Issues During and After Pregnancy")) {
//                    fragment = new MentalHealthFrag();
//                } else if (term2.getTitle().equals("Medications and Supplements Considered Safe During Pregnancy")) {
//                    fragment = new MedsFrag();
//                } else if (term2.getTitle().equals("Teen Pregnancy")) {
//                    fragment = new TeenFrag();
//                } else if (term2.getTitle().equals("Pre-Conception Health")) {
//                    fragment = new PreConceptionFrag();
//                } else if (term2.getTitle().equals("Breastfeeding")) {
//                    fragment = new BreastfeedingFrag();
//                } else if (term2.getTitle().equals("Prenatal Medical Procedures")) {
//                    fragment = new PrenatalFrag();
//                } else if (term2.getTitle().equals("Preparation for Delivery")) {
//                    fragment = new DeliveryFrag();
//                } else if (term2.getTitle().equals("Pregnancy Complications")) {
//                    fragment = new ComplicationsFrag();
//                } else if (term2.getTitle().equals("Next Steps")) {
//                    fragment = new NextStepsFrag();
//                } else if (term2.getTitle().equals("Domestic Violence and Sexual Assault")) {
//                    fragment = new ViolenceFrag();
//                } else if (term2.getTitle().equals("Alcohol")) {
//                    fragment = new AlcoholFrag();
//                } else if (term2.getTitle().equals("Secondhand Smoke")) {
//                    fragment = new SecondhandSmokeFrag();
//                }
                String fragTitle = term2.getTitle();
                Fragment fragment = PDFViewerFrag.newInstance(fragTitle);
                mFragmentManager.beginTransaction()
                        .replace(R.id.glossary_frame_layout, fragment).addToBackStack(null).commit();
            }
        });

        // Return a new holder instance
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        GlossaryTerm term = glossaryList.get(position);
        holder.title.setText(term.getTitle());
        holder.genre.setText(term.getGenre());
        holder.year.setText(term.getYear());

        //int textColor = R.color.colorText;
        holder.title.setTextColor(term.getColor());

    }

    @Override
    public int getItemCount() {
        return glossaryList.size();
    }
}
