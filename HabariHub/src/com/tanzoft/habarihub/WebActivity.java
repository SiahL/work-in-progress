package com.tanzoft.habarihub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class WebActivity extends Activity {

    WebView myweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Bundle b = getIntent().getExtras();
        String url = (String) b.get("site");
        myweb = (WebView) findViewById(R.id.web1);
        WebSettings webSettings = myweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myweb.setWebViewClient(new myWebClient());
        myweb.loadUrl(url);

    }

}
