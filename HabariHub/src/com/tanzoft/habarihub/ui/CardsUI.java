package com.tanzoft.habarihub.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.RSSFeed;
import com.tanzoft.habarihub.parser.RSSItem;

public class CardsUI extends Activity {

    private CardUI mCardView;
    private String RSSFEEDURL;
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

        feed = (RSSFeed) getIntent().getExtras().get("feed");

        mCardView = (CardUI) findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);
        


        for (int i = 0; i < feed.getItemCount(); i++) {
            final int pos = i;
            RSSItem item = feed.getItem(i);
            //String desc = item.getDescription();
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

}
