package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlogsActivity extends ListActivity {

    String[] blogsList = { "Michuzi Blog", "MillardAyo", "John Kitime Blog",
            "King Kapita", "Fununu Blog", "Gospel Kitaa" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(BlogsActivity.this,
                android.R.layout.simple_list_item_1, blogsList));
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
            blogSite = "http://www.chekanakitime.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 3:
            blogSite = "http://www.kingkapita.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 4:
            blogSite = "http://www.fununuhabarii.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 5:
            blogSite = "http://www.gospelkitaa.blogspot.com/feeds/posts/default?alt=rss";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.rss_activities.SplashActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;


        }
    }

}
