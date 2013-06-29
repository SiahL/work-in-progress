package com.tanzoft.habarihub.rss_activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
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

@SuppressLint("SetJavaScriptEnabled")
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
        desc.setWebChromeClient(new WebChromeClient());

        // Enable the vertical fading edge (by default it is disabled)
        ScrollView sv = (ScrollView) view.findViewById(R.id.sv);
        sv.setVerticalFadingEdgeEnabled(true);

        // Set WebView properties
        WebSettings ws = desc.getSettings();
        ws.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        ws.setLightTouchEnabled(false);
        ws.setPluginState(PluginState.ON);
        ws.setJavaScriptEnabled(true);
        ws.setUserAgentString("Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");

        // Set the views
        title.setText(fFeed.getItem(fPos).getTitle());
        desc.loadDataWithBaseURL("http://www.tanzoft.com/", fFeed.getItem(fPos)
                .getDescription(), "text/html", "utf-8", null);

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
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Shared from Habari Hub Android App:\n");
        String shareLink = fFeed.getItem(fPos).getTitle() + "\n"
                + Html.fromHtml(fFeed.getItem(fPos).getLink());
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareLink);

        // Set the share intent
        mShareActionProvider.setShareIntent(shareIntent);

        super.onCreateOptionsMenu(menu, inflater);
    }
}
