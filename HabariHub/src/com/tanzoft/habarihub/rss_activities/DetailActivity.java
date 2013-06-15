package com.tanzoft.habarihub.rss_activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.RSSFeed;

public class DetailActivity extends SherlockFragmentActivity {

	RSSFeed feed;
	int pos;
	private DescAdapter adapter;
	private ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
/*
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		*/

		// Get the feed object and the position from the Intent
		feed = (RSSFeed) getIntent().getExtras().get("feed");
		pos = getIntent().getExtras().getInt("pos");

		// Initialize the views
		adapter = new DescAdapter(getSupportFragmentManager());
		pager = (ViewPager) findViewById(R.id.pager);

		// Set Adapter to pager:
		pager.setAdapter(adapter);
		pager.setCurrentItem(pos);

	}
/*
	@Override

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case android.R.id.home:
			// app icon in action bar clicked; finish activity to go home
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	} */

	public class DescAdapter extends FragmentStatePagerAdapter {
		public DescAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return feed.getItemCount();
		}

		@Override
		public Fragment getItem(int position) {

			DetailFragment frag = new DetailFragment();

			Bundle bundle = new Bundle();
			bundle.putSerializable("feed", feed);
			bundle.putInt("pos", position);
			frag.setArguments(bundle);

			return frag;

		}

	}

}
