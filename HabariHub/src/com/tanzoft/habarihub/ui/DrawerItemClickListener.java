package com.tanzoft.habarihub.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tanzoft.habarihub.MainActivity;

public class DrawerItemClickListener implements ListView.OnItemClickListener {

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long id) {

		selectPosition(position);

	}

	public void selectPosition(int position) {
/*
		switch (position) {
		case 0:
			Intent blogs = new Intent(this,
					com.tanzoft.habarihub.BlogsActivity.class);
			startActivity(blogs);
			mSideList.setItemChecked(position, true);
			break;

		case 1:
			Intent news = new Intent(MainActivity.this,
					com.tanzoft.habarihub.MagazetiActivity.class);
			startActivity(news);
			mSideList.setItemChecked(position, true);
			break;

		case 2:
			Intent radio = new Intent(this,
					com.tanzoft.habarihub.RadioActivity.class);
			startActivity(radio);
			mSideList.setItemChecked(position, true);
			break;

		case 3:
			Intent video = new Intent(MainActivity.this,
					com.tanzoft.habarihub.VideosActivity.class);
			startActivity(video);
			mSideList.setItemChecked(position, true);
			break;

		case 4:
			Intent about = new Intent(MainActivity.this,
					com.tanzoft.habarihub.AboutActivity.class);
			startActivity(about);
			mSideList.setItemChecked(position, true);
			break;

		case 5:
			Intent credit = new Intent(MainActivity.this,
					com.tanzoft.habarihub.CreditsActivity.class);
			startActivity(credit);
			mSideList.setItemChecked(position, true);
			break;

		} */
	}
}
