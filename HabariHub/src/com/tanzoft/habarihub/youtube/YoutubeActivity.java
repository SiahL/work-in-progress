package com.tanzoft.habarihub.youtube;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.tanzoft.habarihub.R;

public class YoutubeActivity extends YouTubeBaseActivity implements
		YouTubePlayer.OnInitializedListener {

	private YouTubePlayerView yPlayerView;
	private YouTubePlayer yPlayer;
	String _id = null;
	private static final String DEVKEY = "AIzaSyDHWJLZ7r7rSBx0iU0Yx1rcIozG1fPFwXA";

	@Override
	protected void onCreate(Bundle onSavedInstance) {
		// TODO Auto-generated method stub
		super.onCreate(onSavedInstance);
		setContentView(R.layout.player_view);
		
		Bundle b = new Bundle();
		_id = b.getString("id");

		yPlayerView = (YouTubePlayerView) findViewById(R.id.yPlayerView);
		yPlayerView.initialize(DEVKEY, this);
	}


	@Override
	public void onInitializationFailure(Provider arg0,
			YouTubeInitializationResult arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInitializationSuccess(Provider arg0, YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
		      player.cueVideo(_id);
		    }
	}

}
