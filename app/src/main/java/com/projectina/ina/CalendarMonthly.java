package com.projectina.ina;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.WebView;

public class CalendarMonthly extends AppCompatActivity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //load webpage with calendar html code into app

        setContentView(R.layout.activity_calendar_monthly);
        wv = (WebView) findViewById(R.id.webView);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        wv.getSettings().setJavaScriptEnabled(true);
        wv.measure(WebView.LayoutParams.WRAP_CONTENT, WebView.LayoutParams.WRAP_CONTENT);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int width = (int) (100.0 * point.x / 340);
        int height = (int) (100.0 * point.y / 375);

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels - actionBarHeight;
//        int width = displayMetrics.widthPixels;

        String html = "<iframe src='https://calendar.google.com/calendar/embed?src=" +
                "svttqkqr143jcadd858a3da8u8%40group.calendar.google.com&ctz=America/New_York' style='border: 0'" +
                "width='" + width + "' height='" + height + "' frameborder='0' scrolling='no'></iframe>";

        wv.loadDataWithBaseURL("", html, mimeType, encoding, "");

    }

}
