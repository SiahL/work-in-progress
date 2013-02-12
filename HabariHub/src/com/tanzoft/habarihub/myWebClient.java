package com.tanzoft.habarihub;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class myWebClient extends WebViewClient{

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		
		return super.shouldOverrideUrlLoading(view, url);
//		view.loadUrl(url);
//		return true;
	}
	


}
