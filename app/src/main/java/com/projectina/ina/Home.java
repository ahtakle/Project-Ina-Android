package com.projectina.ina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void dispatchMapIntent(View view) {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Send button */
    public void dispatchTrimesterIntent(View view) {
        Intent intent = new Intent(this, InfoNav.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }

    public void dispatchGlossaryIntent(View view) {
        Intent intent = new Intent(this, Glossary.class);
        startActivity(intent);
    }



}
