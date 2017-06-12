package com.projectina.ina;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Calendar extends AppCompatActivity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_monthly);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //load webpage with calendar html code into app
        wv = (WebView) findViewById(R.id.webView);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        wv.getSettings().setJavaScriptEnabled(true);
        wv.measure(WebView.LayoutParams.WRAP_CONTENT, WebView.LayoutParams.WRAP_CONTENT);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int width = (int) (100.0 * point.x / 320);//(int) (100.0 * point.x / 360);
        int height = (int) (100.0 * point.y / 360);//(int) (100.0 * point.y / 425);

        //This logic allows to fit screen exactly, but then the text is super small.... :(
        //DO NOT DELETE YET!

//        int actionBarHeight = 0;
//
//        // Calculate ActionBar height
//        TypedValue tv = new TypedValue();
//        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
//        {
//            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
//        }
//
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels - (actionBarHeight+20);
//        int width = displayMetrics.widthPixels-10;

        String html = "<iframe src='https://calendar.google.com/calendar/embed?src=" +
                "c4hsduhjqb118qhp4ft3glkqeo%40group.calendar.google.com&ctz=America%2FNew_York' style='border: 0'" +
                "width='" + width + "' height='" + height + "' frameborder='0' scrolling='no'></iframe>";

        wv.loadDataWithBaseURL("", html, mimeType, encoding, "");
        //This fits it to the exact screen size, but then text is too small :(
//        wv.getSettings().setLoadWithOverviewMode(true);
//        wv.getSettings().setUseWideViewPort(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //popUpWindow = new PopupWindow(this);

        if (id == R.id.action_about_me) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_tutorial) {
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
