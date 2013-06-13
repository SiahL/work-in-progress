package com.tanzoft.habarihub.rss_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.RSSFeed;

public class DetailFragment extends SherlockFragment {
	private int fPos;
	RSSFeed fFeed;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		fFeed = (RSSFeed) getArguments().getSerializable("feed");
		fPos = getArguments().getInt("pos");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.detail_fragment, container, false);

		// Should call this to trigger Menu
		setHasOptionsMenu(true);

		// Initializer views
		TextView title = (TextView) view.findViewById(R.id.title);
		WebView desc = (WebView) view.findViewById(R.id.desc);

		// Enable the vertical fading edge (by default it is disabled)
		ScrollView sv = (ScrollView) view.findViewById(R.id.sv);
		sv.setVerticalFadingEdgeEnabled(true);

		// Set WebView properties
		WebSettings ws = desc.getSettings();
		ws.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		ws.setLightTouchEnabled(false);
		ws.setPluginState(PluginState.ON);
		ws.setJavaScriptEnabled(true);
		ws.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");

		// Set the views
		title.setText(fFeed.getItem(fPos).getTitle());
		desc.loadDataWithBaseURL("http://www.tanzoft.com/", fFeed
				.getItem(fPos).getDescription(), "text/html", "UTF-8", null);

		return view;
	}

    @Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.activity_desc, menu);

		// Locate MenuItem with ShareActionProvider
		MenuItem shareItem = menu.findItem(R.id.share_option);

		// Fetch and store ShareActionProvider
		ShareActionProvider mShareActionProvider = (ShareActionProvider) shareItem
				.getActionProvider();

		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_SUBJECT, "RSS Reader");
		String shareBody = fFeed.getItem(fPos).getTitle() + "\n"
				+ fFeed.getItem(fPos).getDescription();
		shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

		// Set the share intent
		mShareActionProvider.setShareIntent(shareIntent);

		super.onCreateOptionsMenu(menu, inflater);
	}
}