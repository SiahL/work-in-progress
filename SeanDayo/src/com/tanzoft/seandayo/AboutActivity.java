package com.tanzoft.seandayo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class AboutActivity extends Activity {
	WebView myweb;

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
		WebSettings webSettings = myweb.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myweb.setWebViewClient(new myWebClient());
		myweb.loadUrl("http://www.facebook.com/pages/sEaN-dAyO/203845439685174?sk=info");

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
