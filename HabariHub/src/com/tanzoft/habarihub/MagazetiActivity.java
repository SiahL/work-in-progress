package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MagazetiActivity extends ListActivity {

    String[] magazeti = { "Habari Leo",
            "Mwananchi", "Mtanzania", "Daily News",
            "Spoti Starehe", "Mwanahalisi", "Raia Mwema", "Daily News" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(MagazetiActivity.this,
                android.R.layout.simple_list_item_1, magazeti));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        String url = "";
        Intent load;

        switch (position) {

        case 0:
            url = "http://www.habarileo.co.tz/index.php/habari-za-kitaifa?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
        case 1:
            url = "http://www.mwananchi.co.tz/-/1597570/1723258/-/view/asFeed/-/4a0vxjz/-/index.xml";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        case 2:
            url = "http://mtanzania.co.tz/index.php?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 3:
            url = "http://www.spoti.co.tz/index.php?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
            
        case 4:
            url = "http://www.spoti.co.tz/index.php?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 5:
            url = "http://www.mwanahalisi.co.tz/rss.xml";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 6:
            url = "http://www.raiamwema.co.tz/rss.xml";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 7:
            url = "http://www.dailynews.co.tz/index.php/local-news?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        }
    }

}
