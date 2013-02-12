package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlogsActivity extends ListActivity {

	String[] blogsList = { "Michuzi Blog", "Candle Heart",
			"BongoFlava TZ", "MillardAyo", "John Kitime Blog",
			"King Kapita", "Fununu Blog", "Gospel Kitaa", "Shaffih Dauda" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(BlogsActivity.this, android.R.layout.simple_list_item_1, blogsList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		switch(v.getId()){
			
		 
		
		}
	}

}
