package com.tanzoft.seandayo;

import java.util.LinkedList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SubContacts extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		final List<String[]> peopleContacts = new LinkedList<String[]>();
		peopleContacts.add(new String[] { "Christopher Shayo",
				"Chief Executive Officer" });
		peopleContacts
				.add(new String[] { "Steven Kilele", "Marketing Manager" });
		peopleContacts
				.add(new String[] { "Philip Kinasha", "Media Consultant" });
		peopleContacts.add(new String[] { "Dennis Mkony", "Promotions" });
		peopleContacts.add(new String[] { "Simeon Mugisha", "Customer Care" });
		peopleContacts
				.add(new String[] { "Damas Mlabwa", "Software Developer" });

		setListAdapter(new ArrayAdapter<String[]>(SubContacts.this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				peopleContacts){
			
			public View getView(int position, View convertView, ViewGroup parent){
				 // Must always return just a View.
                View view = super.getView(position, convertView, parent);
 
                // If you look at the android.R.layout.simple_list_item_2 source, you'll see
                // it's a TwoLineListItem with 2 TextViews - text1 and text2.
                //TwoLineListItem listItem = (TwoLineListItem) view;
                String[] entry = peopleContacts.get(position);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText(entry[0]);
                text2.setText(entry[1]);
                return view;
				
			}
			
			
		} );

	}
	
	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	/*	try {
			Class subContacts = Class.forName("com.tanzoft.seandayo.SubContacts");
			Intent callSubContacts = new Intent(SubContacts.this, subContacts);
			startActivity(callSubContacts);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

}
