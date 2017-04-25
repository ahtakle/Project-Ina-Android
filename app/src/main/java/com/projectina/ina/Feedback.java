package com.projectina.ina;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {

    private Button buttonSubmitFeedback;
    private EditText textEmail;
    private EditText textName;
    private EditText textBody;
    private boolean questionsClicked = true; //questions button is clicked at initialization
    private boolean suggestionsClicked = false; //suggestions button is not clicked
    //buttons for questions and suggestions should toggle - one and only one should be clicked at once
    private Button buttonQuestions;
    private Button buttonSuggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create listener for Submit Feedback button
        buttonSubmitFeedback = (Button) findViewById(R.id.buttonSubmitFeedback);
        buttonSubmitFeedback.setOnClickListener(onClickListener);
        textEmail = (EditText) findViewById(R.id.userEmail);
        textName = (EditText) findViewById(R.id.userName);
        textBody = (EditText) findViewById(R.id.emailBody);

        //create listener to toggle between Questions and Suggestions buttons
        buttonQuestions = (Button) findViewById(R.id.buttonQuestions);
        buttonQuestions.setOnClickListener(onClickListener);
        buttonSuggestions = (Button) findViewById(R.id.buttonSuggestions);
        buttonSuggestions.setOnClickListener(onClickListener);

    }


    //Send an email to the project when "Submit" is clicked
    public void sendEmail() {

        String[] TO = {"ahtakle@virginia.edu"};
        String[] CC = {textEmail.getText().toString()};
        String subject = "Project Ina - " + textName.getText().toString() + " has a ";
        if (questionsClicked) subject += "Question";
        else subject += "Suggestion";
        String body = textBody.getText().toString();


        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
        }
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {

            switch (v.getId()) {
                case R.id.buttonSubmitFeedback:
                    sendEmail();
                    break;
                case R.id.buttonQuestions:
                    if (!questionsClicked) {
                        buttonQuestions.setBackgroundColor(getResources().getColor(R.color.colorAccent, null));
                        buttonSuggestions.setBackgroundColor(Color.WHITE);
                        questionsClicked = true;
                        suggestionsClicked = false;
                    }
                    break;
                case R.id.buttonSuggestions:
                    if (!suggestionsClicked) {
                        buttonSuggestions.setBackgroundColor(getResources().getColor(R.color.colorAccent, null));
                        buttonQuestions.setBackgroundColor(Color.WHITE);
                        questionsClicked = false;
                        suggestionsClicked = true;
                    }
                    break;
            }
        }
    };

    private OnFragmentInteractionListener mListener;

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

}