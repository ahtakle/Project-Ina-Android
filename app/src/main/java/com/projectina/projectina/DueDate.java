package com.projectina.projectina;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;


public class DueDate extends AppCompatActivity {

    public static final String PREFS_NAME = "InaPrefsFile";

    private DatePicker datePicker;
    private int mYear;
    private int mMonth;
    private int mDay;

    private String due_date;

    private Button submit_duedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due_date);


        Calendar mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        datePicker = (DatePicker) findViewById(R.id.datepicker);

        datePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker v, int year, int month, int day) {
                mYear = year;
                mMonth = month;
                mDay = day;
            }
        });


        Bundle b = getIntent().getExtras();
        int v = -1; // or other values
        if (b != null)
            v = b.getInt("date_type");
        final int value = v;

        submit_duedate = (Button) findViewById(R.id.due_date_btn);
        if (value == 1)
            submit_duedate.setText("Select Due Date");
        else
            submit_duedate.setText("Select Birth Date");

        submit_duedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();


                //Error handling
                java.util.Calendar mcurrentDate = java.util.Calendar.getInstance();
                int currYear = mcurrentDate.get(java.util.Calendar.YEAR);
                int currMonth = mcurrentDate.get(java.util.Calendar.MONTH);
                int currDay = mcurrentDate.get(java.util.Calendar.DAY_OF_MONTH);
                Date currDate = new Date(currYear, currMonth, currDay);
                Date date = new Date(mYear, mMonth, mDay);
                final int millisInDay = 1000 * 60 * 60 * 24;
                int diffInWeeks = (int) ((date.getTime() - currDate.getTime()) / millisInDay / 7);
                int diffInDays = (int) ((currDate.getTime() - date.getTime()) / millisInDay);
                System.out.println("value: " + value + ", diffInWeeks: " + diffInWeeks);
                if (value == 1 && (diffInWeeks > 42 || date.getTime() < currDate.getTime())) { //Due date selected
                    //Due date is invalid
                    editor.putString("date_type", "invalid_due_date");
                    editor.apply();
                    Intent intent = new Intent(DueDate.this, InvalidDateProgress.class);
                    startActivity(intent);
                } else if (value == 2 && (diffInDays > 365 * 3 || date.getTime() > currDate.getTime())) {
                    //Birth date is invalid
                    editor.putString("date_type", "invalid_birth_date");
                    editor.apply();
                    Intent intent = new Intent(DueDate.this, InvalidDateProgress.class);
                    startActivity(intent);
                } else {
                    //Save date to SharedPreferences
                    due_date = (mMonth + 1) + "/" + mDay + "/" + mYear;
                    editor.putString("date", due_date);
                    editor.putString("month", mMonth + "");
                    editor.putString("day", mDay + "");
                    editor.putString("year", mYear + "");
                    if (value == 1)
                        editor.putString("date_type", "due_date");
                    else
                        editor.putString("date_type", "birth_date");
                    editor.apply();
                    Intent intent = new Intent(DueDate.this, Home.class);
                    startActivity(intent);
                }
            }
        });

    }
}
