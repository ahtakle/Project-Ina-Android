package com.projectina.ina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DateOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void dispatchDueDate(View view) {
        Intent intent = new Intent(this, DueDate.class);
        Bundle b = new Bundle();
        b.putInt("date_type", 1);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void dispatchBirthDate(View view) {
        Intent intent = new Intent(this, DueDate.class);
        Bundle b = new Bundle();
        b.putInt("date_type", 2);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void dispatchNoDate(View view) {
        Intent intent = new Intent(this, NoDueDateProgress.class);
        startActivity(intent);
    }

}
