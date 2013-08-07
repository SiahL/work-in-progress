package com.tanzoft.habarihub.youtube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.DOMParser;
import com.tanzoft.habarihub.parser.RSSFeed;

public class YoutubeSplashActivity extends SherlockActivity {

	public String RSSFEEDURL;
	RSSFeed feed;
	String fileName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle b = getIntent().getExtras();
        RSSFEEDURL = (String) b.get("site");

		setContentView(R.layout.splash);
		
		fileName = "TDRSSFeed.td";

		File feedFile = getBaseContext().getFileStreamPath(fileName);

		ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conMgr.getActiveNetworkInfo() == null) {

			// No connectivity. Check if feed File exists
			if (!feedFile.exists()) {

				// No connectivity & Feed file doesn't exist: Show alert to exit
				// & check for connectivity
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage(
						"Unable to reach server, \nPlease check your connectivity.")
						.setTitle("Habari Hub")
						.setCancelable(false)
						.setPositiveButton("Exit",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int id) {
										finish();
									}
								});

				AlertDialog alert = builder.create();
				alert.show();
			} else {

				// No connectivty and file exists: Read feed from the File
				Toast toast = Toast.makeText(this,
						"No connectivity! Reading last update...",
						Toast.LENGTH_LONG);
				toast.show();
				feed = ReadFeed(fileName);
				startListActivity(feed);
			}

		} else {

			// Connected - Start parsing
			new AsyncLoadXMLFeed().execute();

		}

	}

	
	private void startListActivity(RSSFeed feed) {

		Bundle bundle = new Bundle();
		bundle.putSerializable("feed", feed);

		// launch List activity
		Intent intent = new Intent(YoutubeSplashActivity.this, YoutubeListView.class);
		intent.putExtras(bundle);
		startActivity(intent);

		// kill this activity
		finish();

	} 
	
	/*
	 
	 //enable this method to launc activity with cards UI instead of list view, remember to comment out above method
	   private void startLisActivity(RSSFeed feed) {

	        Bundle bundle = new Bundle();
	        bundle.putSerializable("feed", feed);

	        // launch List activity
	        Intent intent = new Intent(SplashActivity.this, com.tanzoft.habarihub.ui.CardsUI.class);
	        intent.putExtras(bundle);
	        startActivity(intent);

	        // kill this activity
	        finish();

	    } */

	private class AsyncLoadXMLFeed extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {

			// Obtain feed
			DOMParser myParser = new DOMParser();
			feed = myParser.parseXml(RSSFEEDURL);
			if (feed != null && feed.getItemCount() > 0)
				WriteFeed(feed);
			return null;

		} 

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			startListActivity(feed);
		}

	}

	// Method to write the feed to the File
	private void WriteFeed(RSSFeed data) {

		FileOutputStream fOut = null;
		ObjectOutputStream osw = null;

		try {
			fOut = openFileOutput(fileName, MODE_PRIVATE);
			osw = new ObjectOutputStream(fOut);
			osw.writeObject(data);
			osw.flush();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				fOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Method to read the feed from the File
	private RSSFeed ReadFeed(String fName) {

		FileInputStream fIn = null;
		ObjectInputStream isr = null;

		RSSFeed _feed = null;
		File feedFile = getBaseContext().getFileStreamPath(fileName);
		if (!feedFile.exists())
			return null;

		try {
			fIn = openFileInput(fName);
			isr = new ObjectInputStream(fIn);

			_feed = (RSSFeed) isr.readObject();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				fIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return _feed;

	}
	
	public void onPause(){
	    super.onPause();
	    finish();
	}

}