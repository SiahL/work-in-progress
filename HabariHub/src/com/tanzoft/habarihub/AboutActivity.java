package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.ui.MyPlayCard;

public class AboutActivity extends SherlockActivity {

	Button developers;
	Button github;
	Button experimental;
	CardUI aboutCards;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		// cards UI
		aboutCards = (CardUI) findViewById(R.id.about_cards);
		aboutCards.setSwipeable(false);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// CardStack dev = new CardStack();
		// dev.setTitle("Developers Info and Stuffs");
		// aboutCards.addStack(dev);

		MyPlayCard developers = new MyPlayCard("Developers",
				"People behind this app", "#e00707", "#e00707", false, false);

		developers.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent devs = new Intent(AboutActivity.this,
						com.tanzoft.habarihub.Developers.class);
				startActivity(devs);

			}
		});

		aboutCards.addCard(developers);

		MyPlayCard github = new MyPlayCard("Source Code at Github",
				"Fork me at github", "#e00707", "#e00707", false, false);

		github.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// url to github source page
				String url = "https://github.com/tanzoft/work-in-progress";
				Intent gh = new Intent(Intent.ACTION_VIEW);
				gh.setData(Uri.parse(url));
				startActivity(gh);
			}
		});

		aboutCards.addCard(github);

//		MyPlayCard experimental = new MyPlayCard(
//				"Experimental Stuffs",
//				"A sneak peak of what it may look like int the future, includes Radio, and new List View[Disabled]",
//				"#e00707", "#e00707", false, false);
//		experimental.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent test = new Intent(AboutActivity.this,
//						com.tanzoft.habarihub.expandable_list.GroupedList.class);
//				startActivity(test);
//
//			}
//		});
//
//		aboutCards.addCard(experimental);

		MyPlayCard credits = new MyPlayCard("Credits", "Our special thanks",
				"#e00707", "#e00707", false, false);
		credits.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent cred = new Intent(AboutActivity.this, com.tanzoft.habarihub.CreditsActivity.class);
				startActivity(cred);
				
			}
		});
		aboutCards.addCard(credits);

		aboutCards.refresh();
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
		}
		return super.onOptionsItemSelected(item);
	}

	// kill activity when it goes in the background
	public void onPause() {
		super.onPause();
	}

}
