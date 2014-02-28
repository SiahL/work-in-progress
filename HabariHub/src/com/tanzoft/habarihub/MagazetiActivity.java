package com.tanzoft.habarihub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;
import com.tanzoft.habarihub.R;

public class MagazetiActivity extends SherlockListActivity {

//	String[] magazeti = { "Business Times", "Daily News", "Habari Leo",
//			"Magazetini", "Mtanzania", "Mwananchi", "Raia Mwema",
//			"The East African", "The Habari" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		FadingActionBarHelper helper = new FadingActionBarHelper();
		helper.actionBarBackground(R.drawable.ab_background)
				.headerLayout(R.layout.list_header_light)
				.contentLayout(R.layout.activity_my_listview);
		setContentView(helper.createView(this));
		helper.initActionBar(this);
		
		ListView magazeti = (ListView) findViewById(android.R.id.list);
		ArrayList<String> items = loadItems(R.raw.magazeti);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        magazeti.setAdapter(adapter);
		
		//setListAdapter(new ArrayAdapter<String>(MagazetiActivity.this,
			//	android.R.layout.simple_list_item_1, magazeti));

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
	
	   /**
     * @return A list of Strings read from the specified resource
     */
    private ArrayList<String> loadItems(int rawResourceId) {
        try {
            ArrayList<String> countries = new ArrayList<String>();
            InputStream inputStream = getResources().openRawResource(rawResourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                countries.add(line);
            }
            reader.close();
            return countries;
        } catch (IOException e) {
            return null;
        }
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String url = "";
		Intent load;

		switch (position) {

		case 1:
			url = "http://www.businesstimes.co.tz/index.php?format=feed&type=rss";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 2:
			url = "http://www.dailynews.co.tz/index.php/local-news?format=feed&type=rss";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 3:
			url = "http://www.habarileo.co.tz/index.php/habari-za-kitaifa?format=feed&type=rss";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 4:
			url = "http://www.magazetini.com/feed";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 5:
			url = "http://mtanzania.co.tz/index.php?format=feed&type=rss";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 6:
			url = "http://www.mwananchi.co.tz/-/1597570/1723258/-/view/asFeed/-/4a0vxjz/-/index.xml";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 7:
			url = "http://www.raiamwema.co.tz/rss.xml";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 8:
			url = "http://www.theeastafrican.co.ke/-/2456/2456/-/view/asFeed/-/13blr5d/-/index.xml";
			load = new Intent(MagazetiActivity.this,
					com.tanzoft.habarihub.rss_activities.SplashActivity.class);
			load.putExtra("site", url);
			startActivity(load);
			break;

		case 9:
			url = "http://www.thehabari.com/feed";
			load = new Intent(MagazetiActivity.this,
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
		} else if (itemId == R.id.rate || itemId == R.id.update) {
			try {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("market://details?id="
								+ "com.tanzoft.habarihub")));
			} catch (android.content.ActivityNotFoundException anfe) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://play.google.com/store/apps/details?id="
								+ "com.tanzoft.habarihub")));
			}
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
		} else if (itemId == R.id.settings) {
			Intent settings = new Intent(this,
					com.tanzoft.habarihub.SettingsActivity.class);
			startActivity(settings);
		}
		return super.onOptionsItemSelected(item);
	}

	// kill activity when it goes in the background
	public void onPause() {
		super.onPause();
		// finish();
	}

}
