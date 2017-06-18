package com.projectina.projectina;

import java.util.ArrayList;

/**
 * Created by zrs on 11/13/16.
 * Basic Java Class for a Glossary Term
 * TODO: Need to change parameters
 */

public class GlossaryTerm {
    private String title;

    public GlossaryTerm() {
    }

    public GlossaryTerm(String title) {
        this.title = title;
    }


    //Here is where we prepare the Glossary Data
    public static ArrayList<GlossaryTerm> prepareGlossaryList() {
        final ArrayList<GlossaryTerm> glossaryList = new ArrayList<GlossaryTerm>();

        glossaryList.add(new GlossaryTerm("Abnormal Pregnancies"));
        glossaryList.add(new GlossaryTerm("Alcohol During Pregnancy"));
        glossaryList.add(new GlossaryTerm("Breastfeeding"));
        glossaryList.add(new GlossaryTerm("Domestic Violence"));
        glossaryList.add(new GlossaryTerm("Family Planning"));
        //glossaryList.add(new GlossaryTerm("Fetal Development"));
        glossaryList.add(new GlossaryTerm("Gestational Diabetes"));
        glossaryList.add(new GlossaryTerm("Healthy Diet"));
        glossaryList.add(new GlossaryTerm("Healthy Relationships"));
        //glossaryList.add(new GlossaryTerm("Mental Health Issues During and After Pregnancy"));
        glossaryList.add(new GlossaryTerm("Next Steps After Finding Out You're Pregnant"));
        glossaryList.add(new GlossaryTerm("Postpartum Depression"));
        glossaryList.add(new GlossaryTerm("Pre-Conception Health"));
        glossaryList.add(new GlossaryTerm("Pre-eclampsia"));
        //glossaryList.add(new GlossaryTerm("Pregnancy Complications"));
        glossaryList.add(new GlossaryTerm("Prenatal Check-ups"));
        glossaryList.add(new GlossaryTerm("Prenatal Tests"));
        glossaryList.add(new GlossaryTerm("Preparing for Delivery"));
        glossaryList.add(new GlossaryTerm("Preterm Birth"));
        glossaryList.add(new GlossaryTerm("Safe Medications During Pregnancy"));
        //glossaryList.add(new GlossaryTerm("Secondhand Smoke"));
        glossaryList.add(new GlossaryTerm("Substance Abuse During Pregnancy"));
        glossaryList.add(new GlossaryTerm("Teenage Pregnancy"));
        glossaryList.add(new GlossaryTerm("Ultrasound Exam"));

        return glossaryList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getColor() {
        return R.color.colorText;
    }
}