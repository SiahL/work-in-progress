package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SocialActivity extends ListActivity {

    String[] channels = { "Millard Ayo(@millardayo)", "John Kitime(@JohnKitime)", "Ambwene 'AY' Yessaya(@Aytanzania)","Jokate Mwegelo(@jokateM)","Flaviana Matata(@FlavianaMatata)","Mkasi (@MkasiTV)" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(SocialActivity.this,
                android.R.layout.simple_list_item_1, channels));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        String url = "";
        Intent load;

        switch (position) {

        case 0:
            url = "https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=millardayo";
            load = new Intent(SocialActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 1:
            url = "https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=JohnKitime";
            load = new Intent(SocialActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 2:
            url = "https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=AyTanzania";
            load = new Intent(SocialActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 3:
            url = "https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=jokateM";
            load = new Intent(SocialActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 4:
            url = "https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=FlavianaMatata";
            load = new Intent(SocialActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 5:
            url = "https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=MkasiTV";
            load = new Intent(SocialActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
        }
    }
}
