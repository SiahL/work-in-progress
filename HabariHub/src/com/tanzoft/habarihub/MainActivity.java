package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.ui.MyPlayCard;

public class MainActivity extends SherlockActivity {

	CardUI mCardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards);

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
		if (itemId == R.id.rate) {
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

		} else {
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

}
