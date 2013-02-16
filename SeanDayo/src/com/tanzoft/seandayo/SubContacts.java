package com.tanzoft.seandayo;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.protocol.HTTP;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//I was going for a simple_list_item_1 menu until I found this from the web, much better than item_1 menu

public class SubContacts extends ListActivity {
	final List<String[]> peopleContacts = new LinkedList<String[]>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Toast.makeText(this, "Touch on person to see contact options",
				Toast.LENGTH_LONG).show();

		// Note - we're specifying android.R.id.text1 as a param, but it's
		// ignored
		// because we override getView(). That param usually tells ArrayAdapter
		// where to find the one TextView entity in a complex layout.
		// If our layout was a simple TextView (like
		// android.R.layout.simple_list_item_1),
		// we wouldn't need that param.

		peopleContacts.add(new String[] { "Christopher Shayo",
				"Co-Founder, CEO", "+255786157782",
				"mixtapeshantall@yahoo.com", "https://twitter.com/cSeandayo" });
		peopleContacts.add(new String[] { "Steven Kilele", "Co-Founder",
				"+255714002823", "stevenkilele92@yahoo.com",
				"https://www.facebook.com/steven.kilele" });
		peopleContacts.add(new String[] { "Philip Kinasha", "Consultant",
				"+16073199112", "pkinasha@gmail.com",
				"https://plus.google.com/100250468248307344507/about" });
		// peopleContacts
		// .add(new String[] { "Dennis Mkony", "Promotions",
		// "+255717369336", "mkony360@yahoo.com",
		// "https://www.google.com" });
		peopleContacts.add(new String[] { "Simeon Mugisha", "Consultant",
				"+60162689443", "cmeo226@yahoo.com",
				"https://plus.google.com/u/0/106366345061442881202/about" });
		peopleContacts.add(new String[] { "Damas Mlabwa", "Software Developer",
				"+13217506744", "mlabwa1@gmail.com",
				"https://plus.google.com/u/0/104081026859969508594/about" });

		setListAdapter(new ArrayAdapter<String[]>(SubContacts.this,
				android.R.layout.simple_list_item_2, android.R.id.text1,
				peopleContacts) {

			public View getView(int position, View convertView, ViewGroup parent) {
				// Must always return just a View.
				View view = super.getView(position, convertView, parent);

				// If you look at the android.R.layout.simple_list_item_2
				// source, you'll see
				// it's a TwoLineListItem with 2 TextViews - text1 and text2.
				// TwoLineListItem listItem = (TwoLineListItem) view;
				String[] entry = peopleContacts.get(position);
				TextView text1 = (TextView) view
						.findViewById(android.R.id.text1);
				text1.setTextColor(Color.WHITE);
				TextView text2 = (TextView) view
						.findViewById(android.R.id.text2);
				text2.setTextColor(Color.WHITE);
				text1.setText(entry[0]);
				text2.setText(entry[1]);
				return view;

			}

		});

		//register context View
		registerForContextMenu(getListView());

		getListView().setBackgroundResource(R.drawable.bg_e);

	}

	/**
	 * This will be invoked when an item in the listview is long pressed if on
	 * Listen item click is not implemented
	 */

	// much of this code is a result of debugging using stackoverflow.com
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Contact me:");

		// Get the info on which item was selected
		getMenuInflater().inflate(R.menu.contacts_menu, menu);

		// Get the Adapter behind your ListView (this assumes you're using
		// a ListActivity; if you're not, you'll have to store the Adapter
		// yourself
		// in some way that can be accessed here.)
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;

		// Retrieve the item that was clicked on
		Adapter myList = getListAdapter();

		@SuppressWarnings("unused")
		Object item = myList.getItem(info.position);
	}

	/** This will be invoked when a menu item is selected */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// Here's how you can get the correct item in onContextItemSelected()
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		@SuppressWarnings("unused")
		Object myItem = getListAdapter().getItem(info.position);

		switch (item.getItemId()) {
		case R.id.text:
			Intent smsIntent = new Intent(Intent.ACTION_VIEW);
			smsIntent.setType("vnd.android-dir/mms-sms");
			smsIntent.putExtra("address", peopleContacts.get(info.position)[2]);
			smsIntent.putExtra("sms_body", "SeanDayo");
			startActivity(smsIntent);
			break;

		case R.id.phone:
			Intent phoneIntent = new Intent(Intent.ACTION_CALL);
			phoneIntent.setData(Uri.parse("tel:"
					+ peopleContacts.get(info.position)[2]));
			startActivity(phoneIntent);
			break;

		case R.id.email:
			Intent emailIntent = new Intent(Intent.ACTION_SEND);
			/*
			 * The intent does not have a URI, so declare the "text/plain" MIME
			 * type, emailIntent.setType("text/plain");
			 */
			emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
			emailIntent.putExtra(Intent.EXTRA_EMAIL,
					new String[] { peopleContacts.get(info.position)[3] }); // recipients

			startActivity(emailIntent);
			break;

		case R.id.social:
			Uri webpage = Uri.parse(peopleContacts.get(info.position)[4]);
			Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
			startActivity(webIntent);
			break;

		}
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		// set Context menu on click
		l.showContextMenuForChild(v);
		// getMenuInflater().inflate(R.menu.contacts_menu, menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.credits:
			Toast.makeText(
					this,
					"Developed by:\nDamas Mlabwa\nPhilip Kinasha\nSimeon Mugisha",
					Toast.LENGTH_LONG).show();
			break;
		case R.id.about:

			break;

		case R.id.help:
			break;
		case R.id.rate:

			break;
		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}

}
