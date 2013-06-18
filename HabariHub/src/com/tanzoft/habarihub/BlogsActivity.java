package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class BlogsActivity extends SherlockListActivity {

    String[] blogsList = { "Michuzi Blog", "MillardAyo", "Bongo 5",
            "Cheka na Kitime", "Cheka Vichekesho", "DJ Choka", "Fununu Blog",
            "Gospel Kitaa", "Kajuna Son", "Kijiwe cha Kitime", "King Kapita",
            "Mpekuzi", "Ramoursnet" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(BlogsActivity.this,
                android.R.layout.simple_list_item_1, blogsList));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        String blogSite = "";
        Intent loadBlog;

        switch (position) {
        case 0:
            blogSite = "http://www.issamichuzi.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 1:
            blogSite = "http://www.millardayo.com/feed";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 2:
            blogSite = "http://www.bongo5.com/feed";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 3:
            blogSite = "http://www.chekanakitime.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 4:
            blogSite = "http://chekavichekesho.wordpress.com/feed";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 5:
            blogSite = "http://djchoka.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 6:
            blogSite = "http://www.fununuhabarii.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 7:
            blogSite = "http://www.gospelkitaa.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 8:
            blogSite = "http://kajunason.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 9:
            blogSite = "http://www.wanamuzikiwatanzania.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 10:
            blogSite = "http://www.kingkapita.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 11:
            blogSite = "http://freebongo.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 12:
            blogSite = "http://ramoursnet.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
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

            // rate application
        case R.id.rate:
            String myUrl = "https://play.google.com/store/apps/details?id=com.tanzoft.habarihub";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
            break;

        case R.id.report:
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            /*
             * The intent does not have a URI, so declare the "text/plain" MIME
             * type, emailIntent.setType("text/plain");
             */
            emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {
                    "damas@tanzoft.com", "cmeo226@yahoo.com",
                    "pkinasha@gmail.com", "igotti47@gmail.com" }); // recipients
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Habari Hub Error");
            startActivity(Intent.createChooser(emailIntent,
                    "Choose Email Client"));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    // kill activity when it goes in the background
    public void onPause() {
        super.onPause();
        // finish();
    }

}
