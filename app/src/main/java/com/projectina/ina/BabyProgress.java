package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BabyProgress extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";
    public static SharedPreferences settings;

    private ProgressBar progressBar = null;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private static List<String> trim1, trim2, trim3, daily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        settings = getSharedPreferences(PREFS_NAME, 0);
        String due_date_str = settings.getString("due_date", "");
        int due_year = Integer.parseInt(settings.getString("due_year", ""));
        int due_month = Integer.parseInt(settings.getString("due_month", ""));
        int due_day = Integer.parseInt(settings.getString("due_day", ""));

        if (due_date_str.equalsIgnoreCase("not selected")) {
        } else {
            progressBar = (ProgressBar) findViewById(R.id.progressBar2);
            progressBar.setVisibility(View.VISIBLE);

            //Average length of pregnancy is 280 days
            final int pregnancyLength = 280;
            progressBar.setMax(pregnancyLength);

            //Get current date
            java.util.Calendar mcurrentDate = java.util.Calendar.getInstance();
            int mYear = mcurrentDate.get(java.util.Calendar.YEAR);
            int mMonth = mcurrentDate.get(java.util.Calendar.MONTH);
            int mDay = mcurrentDate.get(java.util.Calendar.DAY_OF_MONTH);

            //Calculate time until due date and display on progress bar
            Date currDate = new Date(mYear, mMonth, mDay);
            Date dueDate = new Date(due_year, due_month, due_day);
            final int millisInDay = 1000 * 60 * 60 * 24;
            int diffInDays = (int) ((dueDate.getTime() - currDate.getTime()) / millisInDay);
            int progress = pregnancyLength - diffInDays;
            progressBar.setProgress(progress);
            int percentDone = (int) ((100.0 * progress) / pregnancyLength);
            if (percentDone > 100) percentDone = 100;
            TextView progressPercentText = (TextView) findViewById(R.id.progress_percent);
            progressPercentText.setText("Progress: " + percentDone + "%");

            //Calculate and display percent done
            //TextView percentDoneText = (TextView) findViewById(R.id.percent_done);
            //percentDoneText.setText("You are " + percentDone + "% done");

            //Display 'subtitles' to the right of the image
            int weeksCompleted = progress / 7;
            int daysCompleted = progress % 7 + 1;
            TextView weekDaySubtitle = (TextView) findViewById(R.id.week_day_subtitle);
            weekDaySubtitle.setText("Week " + weeksCompleted + ", Day " + daysCompleted);
            TextView trimSubtitle = (TextView) findViewById(R.id.trim_subtitle);

            //Calculate and display weekly information
            TextView weekTitle = (TextView) findViewById(R.id.progress_weeks_title);
            TextView weekInfo = (TextView) findViewById(R.id.progress_weeks_info);
            String[] weeklyInfo = getResources().getStringArray(R.array.weekly_info);
            weekTitle.setText("Week " + weeksCompleted + " Facts");
            if (weeksCompleted > 40) //for testing
                weeksCompleted = 40;
            weekInfo.setText(weeklyInfo[weeksCompleted - 1]);

            //Change image based on week
            ImageView imageView = (ImageView) findViewById(R.id.weekly_img);
            int resId = getResources().getIdentifier("week_" + weeksCompleted, "mipmap", getPackageName());
            imageView.setImageResource(resId);
            Log.d("image", resId + "");

            //Display trimester information
            //Info from: http://www.webmd.com/baby/tc/pregnancy-your-first-trimester#1
            TextView trimTitleText = (TextView) findViewById(R.id.trimTitle);
            TextView trimTitleInfo = (TextView) findViewById(R.id.trimInfo);

            if (weeksCompleted <= 12) {
                trimTitleText.setText("Trimester 1 Facts");
                trimTitleInfo.setText(getResources().getString(R.string.trim_1));
                trimSubtitle.setText("Trimester 1");
            } else if (weeksCompleted <= 28) {
                trimTitleText.setText("Trimester 2 Facts");
                trimTitleInfo.setText(getResources().getString(R.string.trim_2));
                trimSubtitle.setText("Trimester 2");
            } else {
                trimTitleText.setText("Trimester 3 Facts");
                trimTitleInfo.setText(getResources().getString(R.string.trim_3));
                trimSubtitle.setText("Trimester 3");
            }

            /*DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            expandableListView.setIndicatorBounds(width - GetPixelFromDips(50), width - GetPixelFromDips(10));*/

            //Put data into drop down menus
            expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
            expandableListDetail = getData();
            expandableListTitle = new ArrayList<String>();
            expandableListTitle.add("Trimester 1");
            expandableListTitle.add("Trimester 2");
            expandableListTitle.add("Trimester 3");
            expandableListTitle.add("Daily");
            expandableListAdapter = new TrimListAdapter(this, expandableListTitle, expandableListDetail);
            expandableListView.setAdapter(expandableListAdapter);
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                @Override
                public void onGroupExpand(int groupPosition) {
                    ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
                    expandableListView.setMinimumHeight(5000);
                    Log.d("height", expandableListView.getHeight() + "");
                }
            });

            expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
                @Override
                public void onGroupCollapse(int groupPosition) {

                }
            });

            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    return false;
                }
            });
        }

    }

    //OnClickListener for CheckBox
    public void trimItemClicked(View view) {
        CheckBox tv = (CheckBox) view.findViewById(R.id.trimListItem);
        String data = tv.getText().toString();
        if (tv.isChecked())
            settings.edit().putBoolean(data, true).apply();
        else
            settings.edit().putBoolean(data, false).apply();
    }

    //Change/Remove Due Date
    public void dispatchDueDate(View view) {
        Intent intent = new Intent(this, DueDate.class);
        startActivity(intent);
    }


    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }


    //Data for drop down menus
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        trim1 = new ArrayList<String>();
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

        trim2 = new ArrayList<String>();
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


        trim3 = new ArrayList<String>();
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


        daily = new ArrayList<String>();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //popUpWindow = new PopupWindow(this);

        if (id == R.id.action_settings) {
            //TODO: Make settings activity... but what do we have??
            //Intent intent = new Intent(this, SettingsActivity.class);
            //startActivity(intent);
            return true;
        } else if (id == R.id.action_about_me) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_help) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_resources) {
            //TODO: Come up with some contact info thing.
            //Note: Aditi has some good code on her original branch for this :)
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
