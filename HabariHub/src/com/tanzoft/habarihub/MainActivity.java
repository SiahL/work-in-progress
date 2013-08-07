package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.ui.MyPlayCard;

public class MainActivity extends SherlockActivity {

	private CardUI mCardView;
	private ListView mSideList;
	private String[] mCategories;
	private DrawerLayout mDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards);

		mCategories = getResources().getStringArray(R.array.categories);
		mSideList = (ListView) findViewById(R.id.drawer_list);
		mDrawer = (DrawerLayout) findViewById(R.id.layout_drawer);

		mSideList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_item, mCategories));
		mDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		mSideList
				.setOnItemClickListener(new DrawerItemClickListener());

		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);

		mCardView = (CardUI) findViewById(R.id.cardsview);
		mCardView.setSwipeable(false);

		// Create a blogs card
		MyPlayCard blogs = new MyPlayCard("Blogs and Sites",
				"Your gateway to latest news from TZ finest", "#e00707",
				"#e00707", false, false);

		blogs.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent blog = new Intent(MainActivity.this,
						com.tanzoft.habarihub.BlogsActivity.class);
				startActivity(blog);

			}
		});
		mCardView.addCard(blogs);

		// create a newspapers card
		MyPlayCard newspapers = new MyPlayCard("Newspapers",
				"Preview latest headlines.", "#e00707", "#e00707", false, false);

		newspapers.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent news = new Intent(MainActivity.this,
						com.tanzoft.habarihub.MagazetiActivity.class);
				startActivity(news);

			}
		});
		mCardView.addCard(newspapers);

		// create radios card
		MyPlayCard radios = new MyPlayCard("Radio",
				"Radio on the go!!(NB: Work in Progress)", "#e00707",
				"#33B5E5", false, false);

		radios.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent radio = new Intent(MainActivity.this,
						com.tanzoft.habarihub.RadioActivity.class);
				startActivity(radio);

			}
		});
		mCardView.addCard(radios);

		// create videos card
		MyPlayCard videos = new MyPlayCard("Videos",
				"Videos from TZ popular youtube channels", "#e00707",
				"#e00707", false, false);

		videos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent video = new Intent(MainActivity.this,
						com.tanzoft.habarihub.VideosActivity.class);
				startActivity(video);

			}
		});
		mCardView.addCard(videos);

		// create about card
		MyPlayCard about = new MyPlayCard("About Us",
				"Know Us. Connect with Us.", "#e00707", "#e00707", false, false);

		about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent abt = new Intent(MainActivity.this,
						com.tanzoft.habarihub.AboutActivity.class);
				startActivity(abt);

			}
		});
		mCardView.addCard(about);

		// draw cards
		mCardView.refresh();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.rate || itemId == R.id.update) {
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
		} else if (itemId == R.id.settings) {
			Intent settings = new Intent(this,
					com.tanzoft.habarihub.SettingsActivity.class);
			startActivity(settings);
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

		else {

			return super.onOptionsItemSelected(item);
		}

		return true;
	}

	public void onPause() {
		super.onPause();
	}

	public void onStop() {
		super.onStop();
	}

	public void onDestroy() {
		super.onDestroy();
	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {
			
			selectPosition(position);

		}
		
		public void selectPosition(int position){
			
			switch(position){
			case 0:
				Intent blogs = new Intent(MainActivity.this,
						com.tanzoft.habarihub.BlogsActivity.class);
				startActivity(blogs);
				mSideList.setItemChecked(position, true);
				break;
				
			case 1:
				Intent news = new Intent(MainActivity.this,
						com.tanzoft.habarihub.MagazetiActivity.class);
				startActivity(news);
				mSideList.setItemChecked(position, true);
				break;
				
			case 2:
				Intent radio = new Intent(MainActivity.this,
						com.tanzoft.habarihub.RadioActivity.class);
				startActivity(radio);
				mSideList.setItemChecked(position, true);
				break;
				
			case 3:
				Intent video = new Intent(MainActivity.this,
						com.tanzoft.habarihub.VideosActivity.class);
				startActivity(video);
				mSideList.setItemChecked(position, true);
				break;
				
			case 4:
				Intent about = new Intent(MainActivity.this,
						com.tanzoft.habarihub.AboutActivity.class);
				startActivity(about);
				mSideList.setItemChecked(position, true);
				break;
				
			case 5:
				Intent credit = new Intent(MainActivity.this,
						com.tanzoft.habarihub.CreditsActivity.class);
				startActivity(credit);
				mSideList.setItemChecked(position, true);
				break;
				
				
				
			}
			//mSideList.setItemChecked(position, true);
		}

	}

}
