package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class VideosActivity extends SherlockListActivity {

	String[] channels = { "Mkasi", "ITV Tanzania", "SwahiliWood",
			"Sporah Show", "Bongo Flava(Radio Mbao)", "Cheusi Dawa",
			"Masoud Kipanya", "Shaffih Dauda" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(VideosActivity.this,
				android.R.layout.simple_list_item_1, channels));

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String url = "";
		Intent load;

		switch (position) {

		case 0:
			url = "http://www.youtube.com/rss/user/MkasiEATV/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 1:
			url = "http://www.youtube.com/rss/user/ITVTZ/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 2:
			url = "http://www.youtube.com/rss/user/swahiliwood/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 3:
			url = "http://www.youtube.com/rss/user/sporahshow/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 4:
			url = "http://www.youtube.com/rss/user/djkvelli/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 5:
			url = "http://www.youtube.com/rss/user/Cheusidawa/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 6:
			url = "http://www.youtube.com/rss/user/TheMasoudkipanya/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 7:
			url = "http://www.youtube.com/rss/user/shaffihdauda/videos.rss";
			load = new Intent(VideosActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			// app icon in action bar clicked; finish activity to go home
			finish();
			return true;
		} else if (itemId == R.id.rate) {
			String myUrl = "https://play.google.com/store/apps/details?id=com.tanzoft.habarihub";
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
		} else if (itemId == R.id.report) {
			Intent emailIntent = new Intent(Intent.ACTION_SEND);
			/*
			 * The intent does not have a URI, so declare the "text/plain" MIME
			 * type, emailIntent.setType("text/plain");
			 */
			emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
			emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {
					"damas@tanzoft.com", "cmeo226@yahoo.com",
					"pkinasha@gmail.com", "igotti47@gmail.com" }); // recipients
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Habari Hub Error");
			startActivity(Intent.createChooser(emailIntent,
					"Choose Email Client"));
		} else if (itemId == R.id.share) {
			Intent share = new Intent("android.intent.action.SEND");
			share.setType("text/plain");
			share.putExtra("android.intent.extra.TEXT",
					"https://play.google.com/store/apps/details?id=com.tanzoft.habarihub");
			share.putExtra("android.intent.extra.SUBJECT",
					"Try Habari Hub Android app!");
			startActivity(Intent.createChooser(share, "Share Habari Hub!!"));
		}
		return super.onOptionsItemSelected(item);
	}

	// kill activity when it goes to background
	public void onPause() {
		super.onPause();
		// finish();
	}

	public void onStop() {
		super.onStop();
	}

}
