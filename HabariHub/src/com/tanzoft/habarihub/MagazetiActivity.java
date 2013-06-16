package com.tanzoft.habarihub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MagazetiActivity extends SherlockListActivity {

    String[] magazeti = { "Business Times", "Daily News", "Habari Leo",
            "Magazetini", "Mtanzania", "Mwananchi", "Raia Mwema",
            "Spoti Starehe", "The East African", "The Habari" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(MagazetiActivity.this,
                android.R.layout.simple_list_item_1, magazeti));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        String url = "";
        Intent load;

        switch (position) {

        case 0:
            url = "http://www.businesstimes.co.tz/index.php?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        case 1:
            url = "http://www.dailynews.co.tz/index.php/local-news?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        case 2:
            url = "http://www.habarileo.co.tz/index.php/habari-za-kitaifa?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;        

        case 3:
            url = "http://www.magazetini.com/feed";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;
            
        case 4:
            url = "http://mtanzania.co.tz/index.php?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        case 5:
            url = "http://www.mwananchi.co.tz/-/1597570/1723258/-/view/asFeed/-/4a0vxjz/-/index.xml";
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
            url = "http://www.spoti.co.tz/index.php?format=feed&type=rss";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        case 8:
            url = "http://www.theeastafrican.co.ke/-/2456/2456/-/view/asFeed/-/13blr5d/-/index.xml";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        case 9:
            url = "http://www.thehabari.com/feed";
            load = new Intent(MagazetiActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            load.putExtra("site", url);
            startActivity(load);
            break;

        }
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
        // finish();
    }

}
