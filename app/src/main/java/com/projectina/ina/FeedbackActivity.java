package com.projectina.ina;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Feedback");

    }

    //Send an email to the project when "Submit" is clicked
    public void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"ahtakle@virginia.edu"};
        String[] CC = {textEmail.getText().toString()};
        String subject = textName.getText().toString() + ": ";
        if (questionsClicked) subject += "Question";
        else subject += "Suggestion";

        Log.d("Subject Line", subject);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        //emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_TEXT, subject);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            //Toast.makeText(TrimestersFrag.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
            Log.e("email error", ex.toString());
        }
    }

    private Button buttonSubmitFeedback;
    private EditText textEmail;
    private EditText textName;
    private EditText textBody;
    private boolean questionsClicked = true; //questions button is clicked at initialization
    private boolean suggestionsClicked = false; //suggestions button is not clicked
    //buttons for questions and suggestions should toggle - one and only one should be clicked at once
    private Button buttonQuestions;
    private Button buttonSuggestions;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {

            switch (v.getId()) {
                case R.id.buttonSubmitFeedback:
                    sendEmail();
                    break;
                case R.id.buttonQuestions:
                    if (!questionsClicked) {
                        buttonQuestions.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        buttonSuggestions.setBackgroundColor(Color.WHITE);
                        questionsClicked = true;
                        suggestionsClicked = false;
                    }
                    break;
                case R.id.buttonSuggestions:
                    if (!suggestionsClicked) {
                        buttonSuggestions.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        buttonQuestions.setBackgroundColor(Color.WHITE);
                        questionsClicked = false;
                        suggestionsClicked = true;
                    }
                    break;
            }
        }
    };

}
