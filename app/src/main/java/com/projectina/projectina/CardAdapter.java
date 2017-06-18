package com.projectina.projectina;

/**
 * Created by nanditakannapadi on 5/6/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ResourceViewHolder>{

    public static class ResourceViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        ResourceViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            personName = (TextView)itemView.findViewById(R.id.textViewName);
            personAge = (TextView)itemView.findViewById(R.id.textViewVersion);
            personPhoto = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    List<CardTerm> persons;
    private android.support.v4.app.FragmentManager fragmentManager;

    CardAdapter(List<CardTerm> persons, android.support.v4.app.FragmentManager fragmentManager){
        this.persons = persons;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public ResourceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        final ResourceViewHolder pvh = new ResourceViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int i = pvh.getAdapterPosition();

                String fragTitle = persons.get(i).name;
                Fragment fragment = PDFViewerFrag.newInstance(fragTitle);

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_resources, fragment).addToBackStack("");
                transaction.commit();
            }
        });

        return pvh;
    }

    @Override
    public void onBindViewHolder(ResourceViewHolder personViewHolder, final int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
