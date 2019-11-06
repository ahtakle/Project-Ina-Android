package com.projectina.projectina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class PregnancyProgress extends AppCompatActivity {

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
        setContentView(R.layout.activity_pregnancy_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Fetal Development OnClick
        Button fetalDevBtn = (Button) findViewById(R.id.fetal_dev);
        fetalDevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = PDFViewerFrag.newInstance("Fetal Development");
                fragmentManager.beginTransaction()
                        .replace(R.id.content_pregnancy_progress, fragment).addToBackStack(null).commit();
            }
        });

        settings = getSharedPreferences(PREFS_NAME, 0);
        String due_date_str = settings.getString("date", "");
        int due_year = Integer.parseInt(settings.getString("year", ""));
        int due_month = Integer.parseInt(settings.getString("month", ""));
        int due_day = Integer.parseInt(settings.getString("day", ""));


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
        TextView dueDateSubtitle = (TextView) findViewById(R.id.due_date_subtitle);
        dueDateSubtitle.setText("Due Date: " + due_date_str);

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


        //Put data into drop down menus
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = getData();
        expandableListTitle = new ArrayList<String>();
        expandableListTitle.add("Trimester 1");
        expandableListTitle.add("Trimester 2");
        expandableListTitle.add("Trimester 3");
        expandableListTitle.add("Daily");
        expandableListAdapter = new TrimListAdapter(this, expandableListTitle, expandableListDetail);
        //Arrow position
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        expandableListView.setIndicatorBounds(width - GetPixelFromDips(100), width);

        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //Increase height of view when expanded
                ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
                expandableListView.getLayoutParams().height = 1000;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //Decrease height of view when collapsed
                ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
                expandableListView.getLayoutParams().height = GetPixelFromDips(245);
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
        Intent intent = new Intent(this, DateOptions.class);
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
        trim1.add("Choose a health care provider");
        trim1.add("Make a prenatal appointment");
        trim1.add("Investigate what your health insurance will cover for prenatal costs and your " +
                "new baby");
        trim1.add("Apply for Medicaid if you need to");
        trim1.add("Discuss with your health care provider: Should I start taking a prenatal " +
                "vitamin with Folic Acid?");
        trim1.add("Discuss with your health care provider: Are my current medications safe to " +
                "take during pregnancy(make sure to bring all medications to your first " +
                "appointment)?");
        trim1.add("Discuss with your health care provider: Are there over-the-counter medications" +
                " or other substances that I should avoid during pregnancy?");
        trim1.add("Discuss with your health care provider: What activities of daily life are " +
                "pregnancy-safe during my fist trimester and are their activities I should avoid?");
        trim1.add("Discuss with your health care provider: Are there prenatal exercises that will" +
                " be beneficial for me during my first trimester?");
        trim1.add("Discuss with your health care provider: How can I get relief from morning " +
                "sickness?");
        trim1.add("Discuss with your health care provider: What are my options for prenatal " +
                "testing?");
        trim1.add("Discuss with your health care provider: What are the signs of pregnancy " +
                "problems and what should I do if I experience them?");
        trim1.add("Discuss with your health care provider: What foods are healthy and what foods " +
                "are not healthy during pregnancy?");
        trim1.add("Discuss with your health care provider: When should I start thinking about a " +
                "birth plan and what are my options?");
        trim1.add("Discuss with your health care provider: Is it safe for me to be vaccinated " +
                "during pregnancy?");
        trim1.add("Stock your kitchen with healthy food");
        trim1.add("Think about when and how you'll announce your pregnancy");
        trim1.add("Pick up pregnancy books");
        trim1.add("Follow your baby's development");
        trim1.add("Start taking belly photos");
        trim1.add("Start a daily ritual to connect with your baby");
        trim1.add("Buy some new bras and underwear");
        trim1.add("Initiate discussions with your partner about parenting");
        trim1.add("Start making a pre and post birth \"baby budget\"");
        trim1.add("Start researching for your birth plan");
        trim1.add("If you are working, research your workplace's maternity leave policies");

        trim2 = new ArrayList<String>();
        trim2.add("Learn about second trimester prenatal visits and tests");
        trim2.add("Make your second trimester prenatal appointments");
        trim2.add("Discuss with your health care provider: What activities of daily life are " +
                "pregnancy-safe during my second trimester?");
        trim2.add("Discuss with your health care provider: Are there prenatal exercises that will" +
                " be beneficial for me during my second trimester?");
        trim2.add("Discuss with your health care provider: What prenatal tests do I need to " +
                "schedule during this time?");
        trim2.add("Discuss with your health care provider: Should I make any changes to my daily " +
                "routines, sleep habits, medications, and foods?");
        trim2.add("Discuss with your health care provider: Do I need to worry about having sex " +
                "with my partner?");
        trim2.add("Discuss with your health care provider: When and how will I find out the sex " +
                "of my baby?");
        trim2.add("Discuss with your health care provider: What if I don't want to know the sex " +
                "of my baby?");
        trim2.add("Make dental appointment to get your teeth cleaned");
        trim2.add("Find a prenatal exercise class, if approved by your health care provider");
        trim2.add("Start shopping for maternity clothes");
        trim2.add("Start thinking about baby names");
        trim2.add("Start moisturizing your belly");
        trim2.add("Decide whether you want to find out the sex of your baby");
        trim2.add("Look into childbirth classes");
        trim2.add("Flesh out your \"baby budget\"");
        trim2.add("Talk to your employer about maternity leave");
        trim2.add("Prepare your older children");
        trim2.add("Prepare your pets");
        trim2.add("Start your childcare search");
        trim2.add("Celebrate your halfway point");
        trim2.add("Plan some adult time and consider a \"babymoon\"");
        trim2.add("Start sleeping on your side");
        trim2.add("Start doing Kegel exercises");
        trim2.add("Think about your baby shower and create a baby registry");
        trim2.add("Write a letter to your baby");
        trim2.add("Ready your baby's room");
        trim2.add("Think about who will care for your baby(daycare, nanny, family member)");
        trim2.add("If you want, find out the gender of your baby");
        trim2.add("Decide whether to hire a professional labor coach(doula/midwife)");
        trim2.add("Research and order nursery furniture, strollers, car seats, and other baby " +
                "supplies(stay within your \"baby budget\")");

        trim3 = new ArrayList<String>();
        trim3.add("Learn about third trimester prenatal visits and tests");
        trim3.add("Make your third trimester prenatal appointments");
        trim3.add("Discuss with your health care provider: What activities of daily life are " +
                "pregnancy-safe during my third trimester?");
        trim3.add("Discuss with your health care provider: Are there restrictions on travel " +
                "during this time?");
        trim3.add("Discuss with your health care provider: Are there prenatal exercises that will" +
                " be beneficial for me during my third trimester?");
        trim3.add("Discuss with your health care provider: What prenatal tests do I need to " +
                "schedule during this time?");
        trim3.add("Discuss with your health care provider: Should I make any changes to my daily " +
                "routines, sleep habits, medications, and foods?");
        trim3.add("Discuss with your health care provider: What should I expect as my delivery " +
                "time draws near?");
        trim3.add("Discuss with your health care provider: How will I know if I'm really in " +
                "labor?");
        trim3.add("Discuss with your health care provider: What should I know about " +
                "late-pregnancy complications?");
        trim3.add("Discuss with your health care provider: What should I expect after giving " +
                "birth?");
        trim3.add("Finalize your birth plan");
        trim3.add("Keep track of your baby's movements");
        trim3.add("Consider more classes");
        trim3.add("Prepare for breastfeeding");
        trim3.add("Choose a pediatrician");
        trim3.add("Think about big decisions(like circumcision if your baby is a boy, religious " +
                "ceremonies, etc.)");
        trim3.add("Set up a safe place for your baby to sleep");
        trim3.add("Wash your baby's clothing and bedding");
        trim3.add("Learn about the stages of labor and coping with labor pain");
        trim3.add("Learn about how your body will look and feel after birth");
        trim3.add("Start thinking about and contacting \"helpers\"(family, friends, daycare, etc" +
                ".)");
        trim3.add("Finalize your post-delivery \"baby budget\"");
        trim3.add("Consider the most financially stressful baby costs and plan for how you might " +
                "deal with them");
        trim3.add("Consider how you might be able to save on recurring expenses");
        trim3.add("Read up on baby care");
        trim3.add("Pack your bags for the hospital or birth center");
        trim3.add("Tour your hospital or birth center");
        trim3.add("Make a plan for when labor starts");
        trim3.add("Look out for late-pregnancy complications");
        trim3.add("Look out for signs of false labor");
        trim3.add("Clean your house in preparation for the baby's arrival");
        trim3.add("Stock up on household and personal supplies");
        trim3.add("Stock up on light entertainment");
        trim3.add("Plan meals and make food for after your baby's born");
        trim3.add("Install your infant car seat");
        trim3.add("Finalize your list of baby names");
        trim3.add("Cope with late-pregnancy jitters");

        daily = new ArrayList<String>();
        daily.add("Daily do's: Drink water");
        daily.add("Daily do's: Eat healthy");
        daily.add("Daily do's: Get a good night's sleep");
        daily.add("Daily do's: Check in with a friend");
        daily.add("Daily do's: Know the signs of a pregnancy problem");
        daily.add("Daily do's: Limit caffeine");
        daily.add("Daily do's: Avoid dangerous food with bacteria, parasites, or toxins like raw " +
                "fish");
        daily.add("Daily do's: Track your weight gain");
        daily.add("Daily don'ts: No smoking");
        daily.add("Daily don'ts: No drinking alcohol");
        daily.add("For fun: Stretch");
        daily.add("For fun: Sneak in a pregnancy power nap");
        daily.add("For fun: Try a relaxation technique");
        daily.add("For fun: Take a quick walk");
        daily.add("For fun: Write down your pregnancy memories");
        daily.add("For fun: Do something nice for yourself");
        daily.add("For fun: Jot down your crazy pregnancy dreams");
        daily.add("For fun: Take belly photos");

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

        if (id == R.id.action_about_me) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_tutorial) {
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
