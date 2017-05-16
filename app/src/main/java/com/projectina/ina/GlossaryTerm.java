package com.projectina.ina;

import java.util.ArrayList;

/**
 * Created by zrs on 11/13/16.
 * Basic Java Class for a Glossary Term
 * TODO: Need to change parameters
 */

public class GlossaryTerm {
    private String title, genre, year;

    public GlossaryTerm() {
    }

    public GlossaryTerm(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }


    //Here is where we prepare the Glossary Data
    public static ArrayList<GlossaryTerm> prepareGlossaryList() {
        ArrayList<GlossaryTerm> glossaryList = new ArrayList<GlossaryTerm>();

        GlossaryTerm term10 = new GlossaryTerm("Teen Pregnancy", "", "");
        glossaryList.add(term10);

        GlossaryTerm term11 = new GlossaryTerm("Pre-Conception Health", "", "");
        glossaryList.add(term11);

        GlossaryTerm term = new GlossaryTerm("Family Planning", "", ""); //
        glossaryList.add(term);

        GlossaryTerm term2 = new GlossaryTerm("Healthy Diet", "", "");
        glossaryList.add(term2);

        GlossaryTerm term3 = new GlossaryTerm("Healthy Relationships", "", "");
        glossaryList.add(term3);

        GlossaryTerm term4 = new GlossaryTerm("Domestic Violence and Sexual Assault", "", "");
        glossaryList.add(term4);

        GlossaryTerm term5 = new GlossaryTerm("Next Steps", "", "");
        glossaryList.add(term5);

        GlossaryTerm term6 = new GlossaryTerm("Substance Abuse During Pregnancy", "", "");
        glossaryList.add(term6);

        GlossaryTerm term17 = new GlossaryTerm("Alcohol", "", "");
        glossaryList.add(term17);

        GlossaryTerm term7 = new GlossaryTerm("Mental Health Issues During and After Pregnancy", "", "");
        glossaryList.add(term7);

        GlossaryTerm term8 = new GlossaryTerm("Medications and Supplements Considered Safe During Pregnancy", "", "");
        glossaryList.add(term8);

        GlossaryTerm term9 = new GlossaryTerm("Fetal Development", "", "");
        glossaryList.add(term9);

        GlossaryTerm term12 = new GlossaryTerm("Breastfeeding", "", "");
        glossaryList.add(term12);

        GlossaryTerm term13 = new GlossaryTerm("Prenatal Medical Procedures", "", ""); //
        glossaryList.add(term13);

        GlossaryTerm term14 = new GlossaryTerm("Preparation for Delivery", "", ""); //
        glossaryList.add(term14);

        GlossaryTerm term15 = new GlossaryTerm("Pregnancy Complications", "", ""); //
        glossaryList.add(term15);

        GlossaryTerm term16 = new GlossaryTerm("Secondhand Smoke", "", ""); //
        glossaryList.add(term16);

        return glossaryList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getColor() {
        return R.color.colorText;
    }
}