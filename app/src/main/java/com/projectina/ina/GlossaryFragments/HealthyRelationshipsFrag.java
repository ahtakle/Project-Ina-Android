package com.projectina.ina.GlossaryFragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectina.ina.R;


public class HealthyRelationshipsFrag extends Fragment {

    View v;
    public HealthyRelationshipsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_healthy_relationships, container, false);
        openFragment("abuse", new ViolenceFrag());

        // Inflate the layout for this fragment
        return v;
    }

    public void openFragment(String string, final Fragment fragment) {
        TextView textView = (TextView) v.findViewById(R.id.relationshipsText);
        String text = textView.getText().toString();
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.glossary_frame_layout, fragment).addToBackStack(null).commit();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        int start = text.indexOf(string);
        int length = start + string.length();
        ss.setSpan(clickableSpan, start, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }

}