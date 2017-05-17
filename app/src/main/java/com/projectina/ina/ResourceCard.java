package com.projectina.ina;

import java.util.ArrayList;

/**
 * Created by nanditakannapadi on 5/6/17.
 */

public class ResourceCard {
    String name;
    String age;
    int photoId;

    ResourceCard(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public static ArrayList<ResourceCard> initializeData() {
        ArrayList<ResourceCard> persons = new ArrayList<>();
        persons.add(new ResourceCard("Coteau", "Coteau Clinic", R.mipmap.coteau));
        persons.add(new ResourceCard("GPTCHB", "Northern Plains Healthy Start", R.mipmap.gptchb));
        persons.add(new ResourceCard("NESD", "Community Health WIC", R.mipmap.nesd));
        persons.add(new ResourceCard("Roberts", "Short description", R.mipmap.roberts));
        persons.add(new ResourceCard("SD Breastfeeding", "Breastfeeding Peer Counsel", R.mipmap.sd_breastfeeding));
        persons.add(new ResourceCard("SD Home Visiting", "Health Bright Start", R.mipmap.sd_homevisiting));
        persons.add(new ResourceCard("SD Social", "Department of Social Services", R.mipmap.sd_socialservices));
        persons.add(new ResourceCard("Sisseton Clinic", "IHS Clinic", R.mipmap.sisseton_clinic));
        persons.add(new ResourceCard("Sisseton Dental", "IHS Dental", R.mipmap.sisseton_dental));
        persons.add(new ResourceCard("Sisseton Nurse", "IHS Public Health", R.mipmap.sisseton_nurse));
        persons.add(new ResourceCard("Sisseton School", "School District SPED", R.mipmap.sisseton_school));
        persons.add(new ResourceCard("SWO Benefits", "Benefits Coordinator", R.mipmap.swo_benefits));
        persons.add(new ResourceCard("SWO Cavity", "Cavity Free", R.mipmap.swo_cavity));
        persons.add(new ResourceCard("SWO Child", "Child Protection", R.mipmap.swo_child));
        persons.add(new ResourceCard("SWO Health Education", "Community Health Ed.", R.mipmap.swo_healthed));
        persons.add(new ResourceCard("SWO Health Rep", "Community Health Rep.", R.mipmap.swo_healthrep));
        persons.add(new ResourceCard("SWO Pride", "Dakota Pride Center", R.mipmap.swo_pride));
        persons.add(new ResourceCard("SWO Intervention", "Early Child Intervention", R.mipmap.swo_intervention));
        persons.add(new ResourceCard("SWO Education", "Education Advice", R.mipmap.swo_education));
        persons.add(new ResourceCard("SWO Food", "Food Pantry", R.mipmap.swo_food));
        persons.add(new ResourceCard("SWO EHS", "Head Start", R.mipmap.swo_ehs));
        persons.add(new ResourceCard("SWO Daycare", "Little Steps Daycare", R.mipmap.swo_daycare));
        persons.add(new ResourceCard("SWO MCH", "Maternal and Child Health", R.mipmap.swo_mch));
        persons.add(new ResourceCard("Finances", "Financial Advice", R.mipmap.finances));
        return persons;
    }
}