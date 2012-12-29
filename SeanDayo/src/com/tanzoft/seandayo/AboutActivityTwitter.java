package com.tanzoft.seandayo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class AboutActivityTwitter extends Activity{
	
	WebView myweb;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_dayo);
		
		
		Toast.makeText(
				this,
				"If it takes more than 30seconds to load, please check your connection",
				Toast.LENGTH_LONG).show();
		myweb = (WebView) findViewById(R.id.web1);
		
		// Hack to let mobile twitter work. From API 7 (Android 2.1) only
				try {
				    Method m = WebSettings.class.getMethod("setDomStorageEnabled", new Class[]{boolean.class});
				    m.invoke(myweb.getSettings(), true);
				} 
				catch (SecurityException e) {} 
				catch (NoSuchMethodException e) {} 
				catch (IllegalArgumentException e) {} 
				catch (IllegalAccessException e) {} 
				catch (InvocationTargetException e) {}

		WebSettings webSettings = myweb.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myweb.setWebViewClient(new myWebClient());
		myweb.loadUrl("https://twitter.com/sEaN_dAyO");

	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.credits:
			Toast.makeText(
					this,
					"Developed by:\nDamas Mlabwa\nPhilip Kinasha\nSimeon Mugisha",
					Toast.LENGTH_LONG).show();
			break;
		case R.id.about:

			break;

		case R.id.help:
			break;
		case R.id.rate:

			break;
		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}


}
