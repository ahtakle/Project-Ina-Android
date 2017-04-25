package com.projectina.ina;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class CalendarAgenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_monthly);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView wv = (WebView) findViewById(R.id.webView);
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        wv.getSettings().setJavaScriptEnabled(true);
        wv.measure(WebView.LayoutParams.WRAP_CONTENT, WebView.LayoutParams.WRAP_CONTENT);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int width = (int) (100.0 * point.x / 320);
        int height = (int) (100.0 * point.y / 355);


        String html = "<iframe src='https://calendar.google.com/calendar/embed?mode=AGENDA&amp;height=600&amp;" +
                "wkst=1&amp;bgcolor=%23FFFFFF&amp;src=svttqkqr143jcadd858a3da8u8%40group.calendar.google.com&amp;" +
                "color=%23182C57&amp;ctz=America%2FNew_York' style='border: 0'" +
                "width='" + width + "' height='" + height + "' frameborder='0' scrolling='no'></iframe>";


        wv.loadDataWithBaseURL("", html, mimeType, encoding, "");
    }

}
