package com.tanzoft.habarihub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.RSSFeed;
import com.tanzoft.habarihub.parser.RSSItem;

public class CardsUI extends SherlockActivity {

    private CardUI mCardView;
    private RSSFeed feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Bundle b = getIntent().getExtras();
        // RSSFEEDURL = (String) b.get("site");

        // DOMParser dp = new DOMParser();
        // RSSFeed fd = dp.parseXml(RSSFEEDURL);

        setContentView(R.layout.activity_cards);
        
        //getActionBar
      ActionBar actionBar = getSupportActionBar();
       actionBar.setDisplayHomeAsUpEnabled(true);

        feed = (RSSFeed) getIntent().getExtras().get("feed");

        //set up card
        mCardView = (CardUI) findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);

        for (int i = 0; i < feed.getItemCount(); i++) {
            final int pos = i;
            RSSItem item = feed.getItem(i);
            // String desc = item.getDescription();
            MyCard current = new MyCard(item.getTitle());
            current.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("feed", feed);
                    Intent intent = new Intent(
                            CardsUI.this,
                            com.tanzoft.habarihub.rss_activities.DetailActivity.class);
                    intent.putExtras(bundle);
                    intent.putExtra("pos", pos);
                    startActivity(intent);

                }
            });
            mCardView.addCard(current);
        }

        mCardView.refresh();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        case android.R.id.home:
            // app icon in action bar clicked; finish activity to go home

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    } 

    // kill activity when it goes in the background
    public void onPause() {
        super.onPause();
        //finish();
    } 

}
