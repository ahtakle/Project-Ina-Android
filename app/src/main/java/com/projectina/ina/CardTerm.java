package com.projectina.ina;

import java.util.ArrayList;

/**
 * Created by nanditakannapadi on 5/6/17.
 *
 * CardTerms work for both Resources and Stories
 */

public class CardTerm {
    String name;
    String age;
    int photoId;

    CardTerm(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    //Create Cards for Resource RecyclerView
    public static ArrayList<CardTerm> initializeResources(int listOption) {
        ArrayList<CardTerm> persons = new ArrayList<>();

        switch (listOption) {
            //Adds to arraylist ALL the resources
            case 1:
                persons.add(new CardTerm("Coteau", "Coteau Clinic", R.mipmap.coteau));
                persons.add(new CardTerm("GPTCHB", "Northern Plains Healthy Start", R.mipmap.gptchb));
                persons.add(new CardTerm("Roberts County", "Community Health WIC", R.mipmap.nesd));
                persons.add(new CardTerm("WIC", "Women, Infants, & Children", R.mipmap.roberts));
                persons.add(new CardTerm("MCH Program", "Breastfeeding Peer Counsel", R.mipmap.sd_breastfeeding));
                //persons.add(new CardTerm("SD Home Visiting", "Health Bright Start", R.mipmap.sd_homevisiting));
                persons.add(new CardTerm("Social Services", "Department of Social Services", R.mipmap.sd_socialservices));
                persons.add(new CardTerm("IHS", "Indian Health Services", R.mipmap.sisseton_clinic)); //Not sure if document is labeled correctly
                persons.add(new CardTerm("Sisseton Dental", "IHS Dental", R.mipmap.sisseton_dental));
                persons.add(new CardTerm("Sisseton Nurse", "IHS Public Health", R.mipmap.sisseton_nurse));
                //persons.add(new CardTerm("Sisseton School", "School District SPED", R.mipmap.sisseton_school));
                persons.add(new CardTerm("Medicaid Eligibility", "Benefits Coordinator", R.mipmap.swo_benefits));
                //persons.add(new CardTerm("SWO Cavity", "Cavity Free", R.mipmap.swo_cavity));
                //persons.add(new CardTerm("SWO Child", "Child Protection", R.mipmap.swo_child));
                persons.add(new CardTerm("SWO Health Education", "Community Health Ed.", R.mipmap.swo_healthed));
                persons.add(new CardTerm("SWO Health Rep", "Community Health Rep.", R.mipmap.swo_healthrep));
                persons.add(new CardTerm("SWO Pride", "Dakota Pride Center", R.mipmap.swo_pride));
                //persons.add(new CardTerm("SWO Intervention", "Early Child Intervention", R.mipmap.swo_intervention));
                persons.add(new CardTerm("SWO Education", "Education Advice", R.mipmap.swo_education));
                persons.add(new CardTerm("SWO Food", "Food Pantry", R.mipmap.swo_food));
                //persons.add(new CardTerm("SWO EHS", "Head Start", R.mipmap.swo_ehs));
                persons.add(new CardTerm("Little Steps Daycare", "SWO Daycare", R.mipmap.swo_daycare));
                persons.add(new CardTerm("SWO MCH", "Maternal and Child Health", R.mipmap.swo_mch));
                persons.add(new CardTerm("MCH", "Maternal and Child Health", R.mipmap.swo_mch)); //Is there a difference between these two?
                //persons.add(new CardTerm("Finances", "Financial Advice", R.mipmap.finances));
                break;
            //Adds to the arraylist the resources for pregnancy
            case 2:
                persons.add(new CardTerm("Coteau", "Coteau Clinic", R.mipmap.coteau));
                persons.add(new CardTerm("Roberts County", "Community Health WIC", R.mipmap.nesd));
                //persons.add(new CardTerm("Roberts", "Short description", R.mipmap.roberts));
                persons.add(new CardTerm("IHS", "Indian Health Services", R.mipmap.sisseton_clinic));
                persons.add(new CardTerm("Sisseton Nurse", "IHS Public Health", R.mipmap.sisseton_nurse));
                persons.add(new CardTerm("SWO Benefits", "Benefits Coordinator", R.mipmap.swo_benefits));
                persons.add(new CardTerm("SWO Health Education", "Community Health Ed.", R.mipmap.swo_healthed));
                persons.add(new CardTerm("SWO Health Rep", "Community Health Rep.", R.mipmap.swo_healthrep));
                persons.add(new CardTerm("SWO Pride", "Dakota Pride Center", R.mipmap.swo_pride));
                persons.add(new CardTerm("SWO MCH", "Maternal and Child Health", R.mipmap.swo_mch));
                break;
            //Adds to the arraylist the resources for after_birth
            case 3:
                persons.add(new CardTerm("MCH Program", "Breastfeeding Peer Counsel", R.mipmap.sd_breastfeeding));
                //persons.add(new CardTerm("SD Home Visiting", "Health Bright Start", R.mipmap.sd_homevisiting));
                //persons.add(new CardTerm("SWO Intervention", "Early Child Intervention", R.mipmap.swo_intervention));
                break;
            //Adds to the arraylist the resources for young_child
            case 4:
                persons.add(new CardTerm("GPTCHB", "Northern Plains Healthy Start", R.mipmap.gptchb));
                persons.add(new CardTerm("Sisseton Dental", "IHS Dental", R.mipmap.sisseton_dental));
                //persons.add(new CardTerm("Sisseton School", "School District SPED", R.mipmap.sisseton_school));
                //persons.add(new CardTerm("SWO Cavity", "Cavity Free", R.mipmap.swo_cavity));
                //persons.add(new CardTerm("SWO Child", "Child Protection", R.mipmap.swo_child));
                persons.add(new CardTerm("SWO Education", "Education Advice", R.mipmap.swo_education));
                persons.add(new CardTerm("SWO Food", "Food Pantry", R.mipmap.swo_food));
                //persons.add(new CardTerm("SWO EHS", "Head Start", R.mipmap.swo_ehs));
                persons.add(new CardTerm("Little Steps Daycare", "Little Steps Daycare", R.mipmap.swo_daycare));
                break;
            //Adds to the arraylist the resources for money/paying for pregnancy
            case 5:
                //persons.add(new CardTerm("Roberts", "Short description", R.mipmap.roberts));
                persons.add(new CardTerm("Social Services", "Department of Social Services", R.mipmap.sd_socialservices));
                persons.add(new CardTerm("SWO Benefits", "Benefits Coordinator", R.mipmap.swo_benefits));
                persons.add(new CardTerm("SWO Food", "Food Pantry", R.mipmap.swo_food));
                //persons.add(new CardTerm("Finances", "Financial Advice", R.mipmap.finances));
                break;
        }

        return persons;
    }

    //Create Cards for RecyclerView
    public static ArrayList<CardTerm> initializeStories() {
        ArrayList<CardTerm> persons = new ArrayList<>();
        persons.add(new CardTerm("Coteau", "Coteau Clinic", R.mipmap.coteau));

        return persons;
    }
}