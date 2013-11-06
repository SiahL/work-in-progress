package com.tanzoft.seandayo;

import android.webkit.WebViewClient;
import android.webkit.WebView;

public class myWebClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {

		return super.shouldOverrideUrlLoading(view, url);
		// view.loadUrl(url);
		// return true;
	}

}
