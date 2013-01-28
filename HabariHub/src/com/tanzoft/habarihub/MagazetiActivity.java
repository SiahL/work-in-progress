package com.tanzoft.habarihub;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MagazetiActivity extends ListActivity {

	String[] magazeti = { "The Citizen", "Nipashe", "Majira", "Habari Leo",
			"Mwananchi", "The Guardian", "Tanzania Daima", "Daily News",
			"Spoti Starehe", "Mwanahalisi", "Raia Mwema" };

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
	}

}
