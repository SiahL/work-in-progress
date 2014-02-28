package com.tanzoft.habarihub.rss_activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.parser.RSSFeed;

@SuppressLint("SetJavaScriptEnabled")
public class DetailFragment extends SherlockFragment {
	private int fPos;
	RSSFeed fFeed;
	TextView title, desc;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		fFeed = (RSSFeed) getArguments().getSerializable("feed");
		fPos = getArguments().getInt("pos");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.detail_fragment, container, false);

		// Should call this to trigger Menu
		setHasOptionsMenu(true);

		// Initializer views
		title = (TextView) view.findViewById(R.id.title);
		desc = (TextView) view.findViewById(R.id.desc);
		
		//make links clickable
		desc.setMovementMethod(LinkMovementMethod.getInstance());

		// set Title
		title.setText(fFeed.getItem(fPos).getTitle());
		
		String htmlString = fFeed.getItem(fPos).getDescription();
		
		//Opening tag
		Pattern pn = Pattern.compile("<iframe src");
		Matcher m = pn.matcher(htmlString);
		while (m.find())
		    htmlString= m.replaceAll("<a href");

		//Closing tag    
		pn = Pattern.compile("frameborder=.*</iframe>");
		m = pn.matcher(htmlString);
		while (m.find())
		  htmlString= m.replaceAll(">CLICK TO WATCH</a>");

		// handle images in description
		URLImageParser p = new URLImageParser(desc, this.getActivity());
		Spanned htmlSpan = Html.fromHtml(htmlString,
				p, null);

		// set description
		desc.setText(htmlSpan);

		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.activity_desc, menu);

		// Locate MenuItem with ShareActionProvider
		MenuItem shareItem = menu.findItem(R.id.share_option);

		// Fetch and store ShareActionProvider
		ShareActionProvider mShareActionProvider = (ShareActionProvider) shareItem
				.getActionProvider();

		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_SUBJECT,
				"Shared from Habari Hub Android App:\n");
		String shareLink = fFeed.getItem(fPos).getTitle() + "\n"
				+ Html.fromHtml(fFeed.getItem(fPos).getLink());
		shareIntent.putExtra(Intent.EXTRA_TEXT, shareLink);

		// Set the share intent
		mShareActionProvider.setShareIntent(shareIntent);

		super.onCreateOptionsMenu(menu, inflater);
	}


	@SuppressWarnings("deprecation")
	public class URLDrawable extends BitmapDrawable {
		// the drawable that you need to set, you could set the initial drawing
		// with the loading image if you need to
		protected Drawable drawable;

		@Override
		public void draw(Canvas canvas) {
			// override the draw to facilitate refresh function later
			if (drawable != null) {
				drawable.draw(canvas);
			}
		}
	}

	public class URLImageParser implements ImageGetter {
		Context c;
		TextView container;

		/***
		 * Construct the URLImageParser which will execute AsyncTask and refresh
		 * the container
		 * 
		 * @param t
		 * @param c
		 */
		public URLImageParser(TextView t, Context c) {
			this.c = c;
			this.container = t;
		}

		public Drawable getDrawable(String source) {
			URLDrawable urlDrawable = new URLDrawable();

			// get the actual source
			ImageGetterAsyncTask asyncTask = new ImageGetterAsyncTask(
					urlDrawable);

			asyncTask.execute(source);

			// return reference to URLDrawable where I will change with actual
			// image from
			// the src tag
			return urlDrawable;
		}

		public class ImageGetterAsyncTask extends
				AsyncTask<String, Void, Drawable> {
			URLDrawable urlDrawable;

			public ImageGetterAsyncTask(URLDrawable d) {
				this.urlDrawable = d;
			}

			@Override
			protected Drawable doInBackground(String... params) {
				String source = params[0];
				return fetchDrawable(source);
			}

			@Override
			protected void onPostExecute(Drawable result) {
				// set the correct bound according to the result from HTTP call
				Log.d("height", "" + result.getIntrinsicHeight());
				Log.d("width", "" + result.getIntrinsicWidth());
				
				int newWidth = result.getIntrinsicWidth();
				int newHeight = result.getIntrinsicHeight();
				
				if(container.getWidth() > newWidth){
					newWidth = container.getWidth();
					newHeight = (newWidth * newHeight)/result.getIntrinsicWidth();
				}
				
				urlDrawable.setBounds(0, 0, newWidth,
						newHeight);

				// change the reference of the current drawable to the result
				// from the HTTP call
				urlDrawable.drawable = result;

				// redraw the image by invalidating the container
				URLImageParser.this.container.invalidate();

				// For ICS+
				URLImageParser.this.container
						.setHeight((URLImageParser.this.container.getHeight() + newHeight));

				// Pre-ICS
				URLImageParser.this.container.setEllipsize(null);
			}

			/***
			 * Get the Drawable from URL
			 * 
			 * @param urlString
			 * @return
			 */
			public Drawable fetchDrawable(String urlString) {
				
				try {
					InputStream is = fetch(urlString);
					Drawable drawable = Drawable.createFromStream(is, "src");
					
					int newWidth = drawable.getIntrinsicWidth();
					int newHeight = drawable.getIntrinsicHeight();
					if(container.getWidth() > newWidth){
						newWidth = container.getWidth();
						newHeight = (newWidth * newHeight)/drawable.getIntrinsicWidth();
					}
					
					//draw object from 0, 0 to drawable width to the right, and height down
					drawable.setBounds(0, 0, 0 + newWidth,
							0 + newHeight);
					
					
					return drawable;
					
				} catch (Exception e) {
					return null;
				}
			}


			private InputStream fetch(String urlString)
					throws MalformedURLException, IOException {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpGet request = new HttpGet(urlString);
				HttpResponse response = httpClient.execute(request);
				return response.getEntity().getContent();
			}
		}
	}
}
