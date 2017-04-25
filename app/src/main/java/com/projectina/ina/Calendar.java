//https://caughtinthemobileweb.wordpress.com/2011/06/20/how-to-implement-calendarview-in-android/

package com.projectina.ina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Calendar extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


    }

    public void openCalendarAgenda(View view) {
        Intent intent = new Intent(this, CalendarAgenda.class);
        startActivity(intent);
    }

    public void openCalendarMonthly(View view) {
        Intent intent = new Intent(this, CalendarMonthly.class);
        startActivity(intent);
    }

}