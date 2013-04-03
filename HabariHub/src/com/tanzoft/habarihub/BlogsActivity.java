package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlogsActivity extends ListActivity {

    String[] blogsList = { "Michuzi Blog", "Candle Heart", "BongoFlava TZ",
            "MillardAyo", "John Kitime Blog", "King Kapita", "Fununu Blog",
            "Gospel Kitaa", "Shaffih Dauda" };

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
            blogSite = "http://www.issamichuzi.blogspot.com";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.WebActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;

        case 3:
            blogSite = "http://www.millardayo.com";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.WebActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;
            
        case 8:
            blogSite = "http://www.shaffihdauda.com";
            loadBlog = new Intent(BlogsActivity.this,
                    com.tanzoft.habarihub.WebActivity.class);
            loadBlog.putExtra("site", blogSite);
            startActivity(loadBlog);
            break;


        }
    }

}
