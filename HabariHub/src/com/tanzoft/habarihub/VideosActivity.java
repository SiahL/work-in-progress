package com.tanzoft.habarihub;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VideosActivity extends ListActivity {

    String[] channels = { "My Channel", "Mkasi", "ITV Tanzania", "SwahiliWood",
            "Sporah Show", "Bongo Flava(Radio Mbao)" };

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(VideosActivity.this,
                android.R.layout.simple_list_item_1, channels));
        
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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

    //kill activity when it goes to background
    public void onPause(){
        super.onPause();
        finish();
    }

}
