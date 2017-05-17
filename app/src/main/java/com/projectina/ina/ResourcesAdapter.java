package com.projectina.ina;

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

public class ResourcesAdapter extends RecyclerView.Adapter<ResourcesAdapter.ResourceViewHolder>{

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

    List<ResourceCard> persons;
    private android.support.v4.app.FragmentManager fragmentManager;

    ResourcesAdapter(List<ResourceCard> persons, android.support.v4.app.FragmentManager fragmentManager){
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
                //Fragment fragment = null;
//                switch (i) {
//                    case 0:
//                        fragment = new CoteauFrag();
//                        break;
//                    case 1:
//                        fragment = new GPTCHBFrag();
//                        break;
//                    case 2:
//                        fragment = new NESDFrag();
//                        break;
//                    case 3:
//                        fragment = new RobertsCountyFrag();
//                        break;
//                    case 4:
//                        fragment = new SDBreastfeedingFrag();
//                        break;
//                    case 5:
//                        fragment = new SDHomeVisitingFrag();
//                        break;
//                    case 6:
//                        fragment = new SDSocialFrag();
//                        break;
//                    case 7:
//                        fragment = new SissetonClinicFrag();
//                        break;
//                    case 8:
//                        fragment = new SissetonDentalFrag();
//                        break;
//                    case 9:
//                        fragment = new SissetonNurseFrag();
//                        break;
//                    case 10:
//                        fragment = new SissetonSchoolFrag();
//                        break;
//                    case 11:
//                        fragment = new SWOBenefitsFrag();
//                        break;
//                    case 12:
//                        fragment = new SWOCavityFrag();
//                        break;
//                    case 13:
//                        fragment = new SWOChildFrag();
//                        break;
//                    case 14:
//                        fragment = new SWOHealthEdFrag();
//                        break;
//                    case 15:
//                        fragment = new SWOHealthRepFrag();
//                        break;
//                    case 16:
//                        fragment = new SWOPrideFrag();
//                        break;
//                    case 17:
//                        fragment = new SWOInterventionFrag();
//                        break;
//                    case 18:
//                        fragment = new SWOEducationFrag();
//                        break;
//                    case 19:
//                        fragment = new SWOFoodFrag();
//                        break;
//                    case 20:
//                        fragment = new SWOEHSFrag();
//                        break;
//                    case 21:
//                        fragment = new SWODaycareFrag();
//                        break;
//                    case 22:
//                        fragment = new SWOMCHFrag();
//                        break;
//                    case 23:
//                        fragment = new FinancesFrag();
//                        break;
//
//                }
//
                String fragTitle = persons.get(i).name;
                Fragment fragment = PDFViewerFrag.newInstance(fragTitle);
                //mFragmentManager.beginTransaction()
                //.replace(R.id.glossary_frame_layout, fragment).addToBackStack(null).commit();

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
