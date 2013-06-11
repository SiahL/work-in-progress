package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VideosActivity extends ListActivity {
    
    String[] channels = { "My Channel", "Mkasi", "ITV Tanzania", "SwahiliWood", "Sporah Show", "Bongo Flava(Radio Mbao)" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(VideosActivity.this,
                android.R.layout.simple_list_item_1, channels));
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        String url = "";
        Intent load;

        switch (position) {

        case 0:
            url = "http://www.youtube.com/rss/user/MrTuxTalk/videos.rss";
            load = new Intent(VideosActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 1:
            url = "http://www.youtube.com/rss/user/MkasiEATV/videos.rss";
            load = new Intent(VideosActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 2:
            url = "http://www.youtube.com/rss/user/ITVTZ/videos.rss";
            load = new Intent(VideosActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 3:
            url = "http://www.youtube.com/rss/user/swahiliwood/videos.rss";
            load = new Intent(VideosActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 4:
            url = "http://www.youtube.com/rss/user/sporahshow/videos.rss";
            load = new Intent(VideosActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 5:
            url = "http://www.youtube.com/rss/user/djkvelli/videos.rss";
            load = new Intent(VideosActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

          
            
            
      

        }
    }


}
