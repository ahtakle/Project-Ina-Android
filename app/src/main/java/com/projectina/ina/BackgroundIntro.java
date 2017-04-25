package com.projectina.ina;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class BackgroundIntro extends AppCompatActivity {

    PopupWindow popUpWindow;
    LayoutInflater layoutInflater;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.background_intro);

        /*openPopup("Secondhand smoke occurs if you are near people that smoke and accidentally breathe in their smoke",
                R.id.background_text, "secondhand smoke", R.layout.popup);
*/


    }

    public void openPopup(final String popup, int id, String string, final int layout) {

        TextView textView = (TextView) findViewById(id);
        String text = textView.getText().toString();
        SpannableString ss = new SpannableString(text);


        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(layout, null);
                popUpWindow = new PopupWindow(container, 500, 500, true);
                popUpWindow.showAtLocation(coordinatorLayout, Gravity.CENTER, 0, 0);
                TextView popupText = (TextView) popUpWindow.getContentView().findViewById(R.id.popupText);
                popupText.setText(popup);
                //popUpWindow.setContentView(R.layout.popup);
                try {
                    coordinatorLayout.getForeground().setAlpha(125);
                } catch (Exception e) {

                }

                popUpWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        try {
                            coordinatorLayout.getForeground().setAlpha(0);
                        } catch (Exception e) {

                        }
                    }
                });
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

    public void openFragment(String string, final Fragment fragment) {
        TextView textView = (TextView) findViewById(R.id.background_text);
        String text = textView.getText().toString();
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                getSupportFragmentManager().beginTransaction().replace(R.id.background_intro, fragment).addToBackStack(null).commit();
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
