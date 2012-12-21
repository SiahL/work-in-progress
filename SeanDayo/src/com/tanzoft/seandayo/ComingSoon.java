package com.tanzoft.seandayo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class ComingSoon extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coming_soon);
		Toast.makeText(
				this,
				"Thank you for downloading our app.\nWe work Day and Night to bring you the best experience.\nStay tuned for coming Updates",
				Toast.LENGTH_LONG).show();
		
	}
	
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
