package com.projectina.ina;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {} interface
 * to handle interaction events.
 * Use the {@link FeedbackFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedbackFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

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

    public FeedbackFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedbackFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedbackFrag newInstance(String param1, String param2) {
        FeedbackFrag fragment = new FeedbackFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        //create listener for Submit Feedback button
        buttonSubmitFeedback = (Button) view.findViewById(R.id.buttonSubmitFeedback);
        buttonSubmitFeedback.setOnClickListener(onClickListener);
        textEmail = (EditText) view.findViewById(R.id.userEmail);
        textName = (EditText) view.findViewById(R.id.userName);
        textBody = (EditText) view.findViewById(R.id.emailBody);

        //create listener to toggle between Questions and Suggestions buttons
        buttonQuestions = (Button) view.findViewById(R.id.buttonQuestions);
        buttonQuestions.setOnClickListener(onClickListener);
        buttonSuggestions = (Button) view.findViewById(R.id.buttonSuggestions);
        buttonSuggestions.setOnClickListener(onClickListener);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
}
