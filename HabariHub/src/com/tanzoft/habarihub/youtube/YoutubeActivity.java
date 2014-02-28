package com.tanzoft.habarihub.youtube;

import java.io.File;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.tanzoft.habarihub.R;

public class YoutubeActivity extends YouTubeBaseActivity implements
		YouTubePlayer.OnInitializedListener {

	private YouTubePlayerView yPlayerView;
	//private YouTubePlayer yPlayer;
	private TextView title;
	String _id = null;
	String _title = null;
	private static final String DEVKEY = "AIzaSyB8jE4N7zradRYHH-9ZT_7JJZfMXJjG5dk";
	private static final int RECOVERY_DIALOG_REQUEST = 1;

	@Override
	protected void onCreate(Bundle onSavedInstance) {
		// TODO Auto-generated method stub
		super.onCreate(onSavedInstance);
		setContentView(R.layout.player_view);

		Bundle b = getIntent().getExtras();
		_id = (String) b.get("id");
		_title = (String) b.get("title");
		

		yPlayerView = (YouTubePlayerView) findViewById(R.id.yPlayerView);
		yPlayerView.initialize(DEVKEY, this);
		
		title = (TextView) findViewById(R.id.vid_title);
		
		
		title.setText(_title);


	}

	@Override
	public void onInitializationFailure(Provider arg0,
			YouTubeInitializationResult errorReason) {
		
	    if (errorReason.isUserRecoverableError()) {
	        errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
	      } else {
	        String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
	        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
	      }

		//Toast.makeText(this, "Failed to launch, make sure you have youtube app is installed", 100).show();

	}

	@Override
	public void onInitializationSuccess(Provider arg0, YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
			player.cueVideo(_id);
		}
	}


	public void onPause() {
		super.onPause();
	}

	public void onDestroy() {
		super.onDestroy();
		try {
			trimCache(this);
		} catch (Exception e) {

			e.printStackTrace();
		}
		finish();
	}

	public void trimCache(Context context) {
		try {
			File dir = context.getCacheDir();
			if (dir != null && dir.isDirectory()) {
				deleteDir(dir);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean deleteDir(File dir) {

		if (dir != null && dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		return dir.delete();
	}
}
