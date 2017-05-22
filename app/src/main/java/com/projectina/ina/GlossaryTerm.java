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
        final ArrayList<GlossaryTerm> glossaryList = new ArrayList<GlossaryTerm>();

        glossaryList.add(new GlossaryTerm("Alcohol", "", ""));
        glossaryList.add(new GlossaryTerm("Breastfeeding", "", ""));
        glossaryList.add(new GlossaryTerm("Domestic Violence and Sexual Assault", "", ""));
        glossaryList.add(new GlossaryTerm("Family Planning", "", ""));
        glossaryList.add(new GlossaryTerm("Fetal Development", "", ""));
        glossaryList.add(new GlossaryTerm("Healthy Diet", "", ""));
        glossaryList.add(new GlossaryTerm("Healthy Relationships", "", ""));
        glossaryList.add(new GlossaryTerm("Medications and Supplements Considered Safe During Pregnancy", "", ""));
        glossaryList.add(new GlossaryTerm("Mental Health Issues During and After Pregnancy", "", ""));
        glossaryList.add(new GlossaryTerm("Next Steps", "", ""));
        glossaryList.add(new GlossaryTerm("Pre-Conception Health", "", ""));
        glossaryList.add(new GlossaryTerm("Pregnancy Complications", "", ""));
        glossaryList.add(new GlossaryTerm("Prenatal Medical Procedures", "", ""));
        glossaryList.add(new GlossaryTerm("Preparation for Delivery", "", ""));
        glossaryList.add(new GlossaryTerm("Secondhand Smoke", "", ""));
        glossaryList.add(new GlossaryTerm("Substance Abuse During Pregnancy", "", ""));
        glossaryList.add(new GlossaryTerm("Teen Pregnancy", "", ""));

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