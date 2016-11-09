package com.projectina.ina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Trimesters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trimesters);
    }

    /** Brings Users to Different Week Sections*/
    /*public void dispatchTrimesterOneWeeksIntent(View view) {
        Intent intent = new Intent(this, Trimester1.class);
        startActivity(intent);
    }

    public void dispatchTrimesterTwoWeeksIntent(View view) {
        Intent intent = new Intent(this, Trimester2.class);
        startActivity(intent);
    }

    public void dispatchTrimesterThreeWeeksIntent(View view) {
        Intent intent = new Intent(this, Trimester3.class);
        startActivity(intent);
    }*/


}
