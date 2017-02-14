package com.projectina.ina;

/**
 * Created by zrs on 11/13/16.
 * Basic RecyclerView Adapter needed to set up the recyclerview
 */


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectina.ina.GlossaryFragments.FetalDevelopmentFrag;
import com.projectina.ina.GlossaryFragments.HealthyRelationshipsFrag;
import com.projectina.ina.GlossaryFragments.NextStepsFrag;

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

        //add onclicklistener here to update the fragment manager based on position

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlossaryTerm term2 = glossaryList.get(position);
                holder.title.setText(term2.getTitle());

                Fragment fragment = new Fragment();
                if (term2.getTitle().equals("Family Planning")) {

                } else if (term2.getTitle().equals("Healthy Diet")) {

                } else if (term2.getTitle().equals("Healthy Relationships")) {
                    fragment = new HealthyRelationshipsFrag();
                } else if (term2.getTitle().equals("Fetal Development")) {
                    fragment = new FetalDevelopmentFrag();
                } else if (term2.getTitle().equals("Next Steps")) {
                    fragment = new NextStepsFrag();
                }

                fragmentManager.beginTransaction()
                        .replace(R.id.glossary_view, fragment).addToBackStack(null).commit();
            }
        });
        /**/

    }

    @Override
    public int getItemCount() {
        return glossaryList.size();
    }
}
