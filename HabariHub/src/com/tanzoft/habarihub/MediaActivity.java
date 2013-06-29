package com.tanzoft.habarihub;

import java.io.IOException;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MediaActivity extends SherlockActivity {
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private String url;
	private ImageButton playButton;
	private ImageButton stopButton;
	private ImageButton pauseButton;
	private TextView statusText;
	private Boolean wasPaused = false;
	private Boolean wasPlaying = false;
	private Boolean wasStopped = false;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
		}

		Intent radio = getIntent();
		url = radio.getStringExtra("MediaActivity");

		// mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		playButton = (ImageButton) findViewById(R.id.playbutton);
		pauseButton = (ImageButton) findViewById(R.id.pausebutton);
		stopButton = (ImageButton) findViewById(R.id.stopbutton);

		statusText = (TextView) findViewById(R.id.textView1);

		playButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// code to play stream

				if (!wasPaused) {
					statusText.setText("Loading");
					statusText.setVisibility(View.VISIBLE);
					try {
						mediaPlayer.setDataSource(url);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						mediaPlayer.prepareAsync();
						wasPaused = false;
						wasPlaying = true;
						wasStopped = false;
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// mediaPlayer.start();

					mediaPlayer.setOnPreparedListener(new OnPreparedListener() {

						public void onPrepared(MediaPlayer mp) {
							// TODO Auto-generated method stub
							statusText.setVisibility(View.INVISIBLE);
							mp.start();
							statusText.setText("Playing");
							statusText.setVisibility(View.VISIBLE);
							// wasPaused = false;
							// wasPlaying = true;
							// wasStopped = false;

						}
					});
				} else {
					statusText.setVisibility(View.VISIBLE);
					statusText.setText("Loading");
					mediaPlayer.start();
					wasPaused = false;
					wasStopped = false;
					// wasPlaying = true;
					statusText.setText("Playing");
				}
			}
		});

		pauseButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (statusText.getText() == "Loading") {
					statusText.setText("Radio not playing. Cannot pause.");
				} else if (wasPlaying) {
					statusText.setText("Paused");
					statusText.setVisibility(View.VISIBLE);
					mediaPlayer.pause();
					wasPaused = true;
					wasStopped = false;
				} else if (wasStopped) {
					statusText.setText("Already Stopped");
					statusText.setVisibility(View.VISIBLE);
				} else {
					statusText.setText("Radio not playing. Cannot pause.");
				}
			}
		});

		stopButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mediaPlayer.stop();
				statusText.setText("Stopped");
				statusText.setVisibility(View.VISIBLE);
				wasPaused = false;
				wasStopped = true;
				wasPlaying = false;
			}
		});

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			// app icon in action bar clicked; finish activity to go home
			finish();
			return true;
		} else if (itemId == R.id.rate) {
			String myUrl = "https://play.google.com/store/apps/details?id=com.tanzoft.habarihub";
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
		} else if (itemId == R.id.report) {
			Intent emailIntent = new Intent(Intent.ACTION_SEND);
			/*
			 * The intent does not have a URI, so declare the "text/plain" MIME
			 * type, emailIntent.setType("text/plain");
			 */
			emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
			emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {
					"damas@tanzoft.com", "cmeo226@yahoo.com",
					"pkinasha@gmail.com", "igotti47@gmail.com" }); // recipients
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Habari Hub Error");
			startActivity(Intent.createChooser(emailIntent,
					"Choose Email Client"));
		} else if (itemId == R.id.share) {
			Intent share = new Intent("android.intent.action.SEND");
			share.setType("text/plain");
			share.putExtra("android.intent.extra.TEXT",
					"https://play.google.com/store/apps/details?id=com.tanzoft.habarihub");
			share.putExtra("android.intent.extra.SUBJECT",
					"Try Habari Hub Android app!");
			startActivity(Intent.createChooser(share, "Share Habari Hub!!"));
		}
		return super.onOptionsItemSelected(item);
	}

	// kill activity when it goes in the background
	@Override
	public void onPause() {
		super.onPause();
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();

		}
		mediaPlayer.release();
		mediaPlayer = null;
		finish();
	}

	public void onStop() {
		super.onStop();
	}

	public void onDestroy() {
		super.onDestroy();
	}

	/*
	 * public void onPause() { super.onPause(); NotificationCompat.Builder
	 * mBuilder = new NotificationCompat.Builder(
	 * this).setSmallIcon(R.drawable.ic_launcher)
	 * .setContentTitle("Habari Hub Radio is running")
	 * .setContentText("Go to radio").setAutoCancel(true); Intent resultIntent =
	 * new Intent(MediaActivity.this, MainActivity.class);
	 * resultIntent.putExtra("MediaActivity", url); TaskStackBuilder
	 * stackBuilder = TaskStackBuilder.from(getApplicationContext());
	 * stackBuilder.addNextIntent(resultIntent); PendingIntent
	 * resultPendingIntent = stackBuilder.getPendingIntent(0,
	 * PendingIntent.FLAG_UPDATE_CURRENT);
	 * mBuilder.setContentIntent(resultPendingIntent); NotificationManager
	 * mNotificationManager = (NotificationManager)
	 * getSystemService(Context.NOTIFICATION_SERVICE);
	 * mNotificationManager.notify(0, mBuilder.getNotification()); }
	 */
}
