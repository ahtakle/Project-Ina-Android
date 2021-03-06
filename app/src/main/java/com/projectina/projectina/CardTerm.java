package com.projectina.projectina;

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
                persons.add(new CardTerm("Roberts County", "Community Health WIC", R.mipmap.nesd));
                persons.add(new CardTerm("WIC", "Women, Infants, & Children", R.mipmap.roberts));
                persons.add(new CardTerm("WIC SD Breastfeeding Peer Counselor", "Breastfeeding Peer Counsel", R.mipmap.sd_breastfeeding));
                persons.add(new CardTerm("Social Services", "Department of Social Services", R.mipmap.sd_socialservices));
                persons.add(new CardTerm("IHS", "Indian Health Services", R.mipmap.sisseton_clinic)); //Not sure if document is labeled correctly
                persons.add(new CardTerm("Sisseton Dental", "IHS Dental", R.mipmap.sisseton_dental));
                persons.add(new CardTerm("Sisseton Nurse", "IHS Public Health", R.mipmap.sisseton_nurse));
                persons.add(new CardTerm("Medicaid Eligibility", "Benefits Coordinator", R.mipmap.swo_benefits));
                persons.add(new CardTerm("SWO Child Protection Program", "Child Protection", R.mipmap.swo_child));
                persons.add(new CardTerm("SWO Community Health Education", "Community Health Ed.", R.mipmap.swo_healthed));
                persons.add(new CardTerm("SWO Health Rep", "Community Health Rep.", R.mipmap.swo_healthrep));
                persons.add(new CardTerm("Dakota Pride", "Dakota Pride Center", R.mipmap.swo_pride));
                persons.add(new CardTerm("SWO Education", "Education Advice", R.mipmap.swo_education));
                persons.add(new CardTerm("SWO Food Pantry", "Food Pantry", R.mipmap.swo_food));
                persons.add(new CardTerm("Little Steps Daycare", "SWO Daycare", R.mipmap.swo_daycare));
                break;
            //Adds to the arraylist the resources for pregnancy
            case 2:
                persons.add(new CardTerm("Coteau", "Coteau Clinic", R.mipmap.coteau));
                persons.add(new CardTerm("Roberts County", "Community Health WIC", R.mipmap.nesd));
                persons.add(new CardTerm("IHS", "Indian Health Services", R.mipmap.sisseton_clinic));
                persons.add(new CardTerm("Sisseton Nurse", "IHS Public Health", R.mipmap.sisseton_nurse));
                persons.add(new CardTerm("SWO Community Health Education", "Community Health Ed.", R.mipmap.swo_healthed));
                persons.add(new CardTerm("SWO Health Rep", "Community Health Rep.", R.mipmap.swo_healthrep));
                persons.add(new CardTerm("Dakota Pride", "Dakota Pride Center", R.mipmap.swo_pride));
                break;
            //Adds to the arraylist the resources for after_birth
            case 3:
                persons.add(new CardTerm("Breastfeeding Aftercare", "MCH Program", R.mipmap.sd_breastfeeding));
                break;
            //Adds to the arraylist the resources for young_child
            case 4:
                persons.add(new CardTerm("Sisseton Dental", "IHS Dental", R.mipmap.sisseton_dental));
                persons.add(new CardTerm("SWO Child Protection Program", "Child Protection", R.mipmap.swo_child));
                persons.add(new CardTerm("SWO Education", "Education Advice", R.mipmap.swo_education));
                persons.add(new CardTerm("SWO Food Pantry", "Food Pantry", R.mipmap.swo_food));
                persons.add(new CardTerm("Little Steps Daycare", "Little Steps Daycare", R.mipmap.swo_daycare));
                break;
            //Adds to the arraylist the resources for money/paying for pregnancy
            case 5:
                persons.add(new CardTerm("Social Services", "Department of Social Services", R.mipmap.sd_socialservices));
                persons.add(new CardTerm("SWO Food Pantry", "Food Pantry", R.mipmap.swo_food));
                break;
        }

        return persons;
    }

    //Create Cards for RecyclerView
    public static ArrayList<CardTerm> initializeStories() {
        ArrayList<CardTerm> stories = new ArrayList<>();
        stories.add(new CardTerm("Dakota Pregnancy Traditions", "", R.mipmap.pregnancy_traditions));
        stories.add(new CardTerm("Pregnancy as Sacred", "", R.mipmap.pregnancy_as_sacred));
        stories.add(new CardTerm("The Woman in the Sky", "Dakota Story", R.mipmap.stars));


        return stories;
    }
}