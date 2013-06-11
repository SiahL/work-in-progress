package com.tanzoft.habarihub;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

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
