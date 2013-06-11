package com.tanzoft.habarihub.rss_activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.RSSFeed;

public class DetailFragment extends Fragment {
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
		desc.loadDataWithBaseURL("http://www.androidcentral.com/", fFeed
				.getItem(fPos).getDescription(), "text/html", "UTF-8", null);

		return view;
	}

	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
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