package com.projectina.ina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;


public class DueDate extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";

    private DatePicker datePicker;
    private GregorianCalendar date;
    private int mYear;
    private int mMonth;
    private int mDay;

    private String due_date;

    private Button submit_duedate;
    private Button select_later;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due_date);

        Calendar mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

//        date = new GregorianCalendar(mYear, mMonth, mDay);
        datePicker = (DatePicker) findViewById(R.id.datepicker);

        datePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker v, int year, int month, int day) {
                mYear = year;
                mMonth = month;
                mDay = day;
//                date = new GregorianCalendar(mYear, mMonth, mDay).getTime();
            }
        });


        submit_duedate = (Button) findViewById(R.id.due_date_btn);
        submit_duedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                due_date = (mMonth + 1) + "/" + mDay + "/" + mYear;
                editor.putString("due_date", due_date);
                editor.putString("due_month", mMonth + "");
                editor.putString("due_day", mDay + "");
                editor.putString("due_year", mYear + "");
                editor.commit();
                Intent intent = new Intent(DueDate.this, Home.class);
                startActivity(intent);
            }
        });

        select_later = (Button) findViewById(R.id.select_later_btn);
        select_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                due_date = "not selected";
                editor.putString("due_date", due_date);
                editor.commit();
                Intent intent = new Intent(DueDate.this, Home.class);
                startActivity(intent);
            }
        });


    }
}
