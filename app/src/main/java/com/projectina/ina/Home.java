package com.projectina.ina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    //Start Map Activity
    public void dispatchMapIntent(View view) {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    // Start Trimester Activity
    public void dispatchTrimesterIntent(View view) {
        Intent intent = new Intent(this, InfoNav.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }

    //Start Glossary Activity
    public void dispatchGlossaryIntent(View view) {
        Intent intent = new Intent(this, Glossary.class);
        startActivity(intent);
    }


}
