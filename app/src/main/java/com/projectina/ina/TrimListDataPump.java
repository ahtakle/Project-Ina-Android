package com.projectina.ina;

/**
 * Created by htakle on 5/22/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrimListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> trim1 = new ArrayList<String>();
        trim1.add("Start taking a prenatal vitamin (make sure Folic Acid is included)");
        trim1.add("Choose a healthcare provider");
        trim1.add("Investigate what your health insurance will cover for prenatal costs and your new baby\n\u2022 Apply for Medicaid if you need to");
        trim1.add("Make a prenatal appointment\n\u2022 Consult your provider about medications you’re taking");
        trim1.add("Make sure your activities of daily life are pregnancy-safe");
        trim1.add("Research prenatal exercises and talk to your doctor about which ones are safe");
        trim1.add("Get relief from morning sickness");
        trim1.add("Consider your options for prenatal testing");
        trim1.add("Pick up pregnancy books");
        trim1.add("Learn the signs of pregnancy problems");
        trim1.add("Think about when and how you’ll announce your pregnancy");
        trim1.add("Follow your baby’s development");
        trim1.add("Start taking belly photos");
        trim1.add("Stock your kitchen with healthy food");
        trim1.add("Start a daily ritual to connect with your baby");
        trim1.add("Buy some new bras and underwear");
        trim1.add("Talk to your partner about parenting");
        trim1.add("Start making a “Baby Budget”");
        trim1.add("Research your birth plan");
        trim1.add("If you are working, research your workplace’s maternity leave policies");
        trim1.add("Learn about vaccines");


        List<String> trim2 = new ArrayList<String>();
        trim2.add("Learn about second-semester prenatal visits and tests");
        trim2.add("Find a prenatal exercise class");
        trim2.add("Start shopping for maternity clothes");
        trim2.add("Decide whether to hire a professional labor coach (doula/midwife)");
        trim2.add("Narrow your baby names list");
        trim2.add("Plan some adult time");
        trim2.add("Start moisturizing your belly");
        trim2.add("Decide whether you want to find out the sex of your baby");
        trim2.add("Look into childbirth classes");
        trim2.add("Flesh out your “Baby Budget”");
        trim2.add("Prepare your older children");
        trim2.add("Prepare your pets");
        trim2.add("Start your childcare search");
        trim2.add("Get your teeth cleaned");
        trim2.add("Celebrate your halfway point");
        trim2.add("Start sleeping on your side");
        trim2.add("Start doing Kegel exercises");
        trim2.add("Talk to your employer about maternity leave");
        trim2.add("Consider a “babymoon”");
        trim2.add("Think about your baby shower\n\u2022 Create a baby registry");
        trim2.add("Write a letter to your baby");
        trim2.add("Tackle your home improvement projects");
        trim2.add("Think about who will care for your baby (daycare, nanny, family member)");
        trim2.add("Make dental appointment");
        trim2.add("If you want to, find out the gender of your baby");
        trim2.add("Research and order nursery furniture, strollers, car seats, and other baby supplies");


        List<String> trim3 = new ArrayList<String>();
        trim3.add("Finalize your birth plan");
        trim3.add("Keep track of your baby’s movements");
        trim3.add("Learn about third-trimester prenatal visits and tests");
        trim3.add("Consider more classes");
        trim3.add("Prepare for breastfeeding");
        trim3.add("Choose a pediatrician");
        trim3.add("Think about big decisions (like circumcision if your baby is a boy, religious ceremonies, etc.)");
        trim3.add("Set up a safe place for your baby to sleep\n\u2022 Wash your baby’s clothing and bedding");
        trim3.add("Learn about the stages of labor and coping with labor pain");
        trim3.add("Start thinking about and contacting “helpers” (family, friends, daycare, etc)");
        trim3.add("Finalize your “Baby Budget”\n\u2022 Consider the most financially stressful baby costs and how you can save");
        trim3.add("Read up on baby care");
        trim3.add("Pack your bag for the hospital or birth center");
        trim3.add("Clean your house");
        trim3.add("Stock up on household and personal supplies");
        trim3.add("Make food for after your baby’s born");
        trim3.add("Install your baby’s car seat");
        trim3.add("Tour your hospital or birth center");
        trim3.add("Make a plan for when labor starts");
        trim3.add("Research and look out for late-pregnancy complications");
        trim3.add("Think about baby names");
        trim3.add("Cope with late pregnancy jitters");
        trim3.add("Learn about how your body will look and feel after birth");
        trim3.add("Stock up on light entertainment");
        trim3.add("Research and look out for false labor signs");
        trim3.add("Decide who will be in your delivery room");
        trim3.add("Get tested for gestational diabetes");
        trim3.add("Pre-register at your hospital");


        List<String> daily = new ArrayList<String>();
        daily.add("Drink water");
        daily.add("Eat healthy");
        daily.add("No smoking");
        daily.add("No drinking alcohol");
        daily.add("Not a lot of caffeine");
        daily.add("Avoid hazardous foods (could have bacteria, parasites, or toxins like raw fish)");
        daily.add("Stretch");
        daily.add("Sneak in a pregnancy power nap");
        daily.add("Try a relaxation technique");
        daily.add("Take a quick walk");
        daily.add("Eat a pregnancy superfood");
        daily.add("Write down your pregnancy memories");
        daily.add("Track your weight gain");
        daily.add("Do something nice for yourself");
        daily.add("Jot down your crazy pregnancy dreams");
        daily.add("Check in with a friend");
        daily.add("Know the signs of a pregnancy problem");
        daily.add("Take belly photos");
        daily.add("Have sex if you feel up to it");
        daily.add("Go to bed early");
        daily.add("Avoid unsafe activities");


        expandableListDetail.put("Trimester 1", trim1);
        expandableListDetail.put("Trimester 2", trim2);
        expandableListDetail.put("Trimester 3", trim3);
        expandableListDetail.put("Daily", daily);
        return expandableListDetail;
    }
}
