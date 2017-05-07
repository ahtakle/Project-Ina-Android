package com.projectina.ina;

/**
 * Created by nanditakannapadi on 5/6/17.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ResourceViewHolder pvh = new ResourceViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ResourceViewHolder personViewHolder, final int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);

        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Fragment fragment = null;
                switch (i) {
                    case 0:
                        fragment = new CoteauFrag();
                        break;
                    case 1:
                        fragment = new GPTCHBFrag();
                        break;
                    case 2:
                        fragment = new NESDFrag();
                        break;
                    case 3:
                        fragment = new RobertsCountyFrag();
                        break;
                    case 4:
                        fragment = new SDBreastfeedingFrag();
                        break;
                    case 5:
                        fragment = new SDHomeVisitingFrag();
                        break;
                    case 6:
                        fragment = new SDSocialFrag();
                        break;
                    case 7:
                        fragment = new SissetonClinicFrag();
                        break;
                    case 8:
                        fragment = new SissetonDentalFrag();
                        break;
                    case 9:
                        fragment = new SissetonNurseFrag();
                        break;
                    case 10:
                        fragment = new SissetonSchoolFrag();
                        break;
                    case 11:
                        fragment = new SWOBenefitsFrag();
                        break;
                    case 12:
                        fragment = new SWOCavityFrag();
                        break;
                    case 13:
                        fragment = new SWOChildFrag();
                        break;
                    case 14:
                        fragment = new SWOHealthEdFrag();
                        break;
                    case 15:
                        fragment = new SWOHealthRepFrag();
                        break;
                    case 16:
                        fragment = new SWOPrideFrag();
                        break;
                    case 17:
                        fragment = new SWOInterventionFrag();
                        break;
                    case 18:
                        fragment = new SWOEducationFrag();
                        break;
                    case 19:
                        fragment = new SWOFoodFrag();
                        break;
                    case 20:
                        fragment = new SWOEHSFrag();
                        break;
                    case 21:
                        fragment = new SWODaycareFrag();
                        break;
                    case 22:
                        fragment = new SWOMCHFrag();
                        break;
                    case 23:
                        fragment = new FinancesFrag();
                        break;

                }

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_resources, fragment).addToBackStack("");
                transaction.commit();
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
