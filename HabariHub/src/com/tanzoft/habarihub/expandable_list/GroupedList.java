package com.tanzoft.habarihub.expandable_list;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockExpandableListActivity;

public class GroupedList extends SherlockExpandableListActivity implements
		OnChildClickListener {

	ArrayList<String> groupItem = new ArrayList<String>();
	ArrayList<Object> childItem = new ArrayList<Object>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExpandableListView blogs = getExpandableListView();
		blogs.setDividerHeight(4);
		blogs.setClickable(true);
		blogs.setGroupIndicator(null);

		setGroupData();
		setChildGroupData();

		NewAdapter mNewAdapter = new NewAdapter(groupItem, childItem);
		mNewAdapter
				.setInflater(
						(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
						this);
		getExpandableListView().setAdapter(mNewAdapter);
		blogs.setOnChildClickListener(this);
	}

	public void setGroupData() {
		groupItem.add("Habari");
		groupItem.add("Injili");
		groupItem.add("Michezo");
		groupItem.add("Muziki");
		groupItem.add("Vichekesho");

	}

	public void setChildGroupData() {

		// Add Data For Habari

		ArrayList<String> child = new ArrayList<String>();
		child.add("Michuzi Blog");
		child.add("Millard Ayo");
		child.add("Fununu Blog");
		child.add("Kajuna Son");
		child.add("Mpekuzi");
		childItem.add(child);

		// Add Data For Injili

		child = new ArrayList<String>();
		child.add("Gospel Kitaa");
		child.add("Injili Leo");
		child.add("Strictly Gospel");
		childItem.add(child);

		// Add Data For Michezo

		child = new ArrayList<String>();
		child.add("Soka in Bongo");
		child.add("Wapenda Soka");
		childItem.add(child);

		// Add Data For Muziki

		child = new ArrayList<String>();
		child.add("Kijiwe cha Kitime");
		childItem.add(child);

		// add data for Vichekesho
		child = new ArrayList<String>();
		child.add("Cheka na Kitime");
		child.add("Cheka Vichekesho");
		childItem.add(child);
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Toast.makeText(this, "Clicked On Child", Toast.LENGTH_SHORT).show();
		return true;
	}

}
