package com.tanzoft.seandayo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Declare buttons
	Button about;
	Button photography;
	Button contacts;
	Button wearables;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize Buttons
		about = (Button) findViewById(R.id.about);
		photography = (Button) findViewById(R.id.photography);
		contacts = (Button) findViewById(R.id.contact);
		wearables = (Button) findViewById(R.id.wearable);

		// set actions for every button click
		about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		photography.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		// open subContacts when contacts button is clicked
		contacts.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openCredits = new Intent(
						"com.tanzoft.SeanDayo.SUBCONTACTS");
				startActivity(openCredits);

			}
		});

		// call credits activity when button_credit is clicked

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);

		return true;
	}
	
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.credits:
        	Toast.makeText(this, "Developed by:\nDamas Mlabwa\nPhilip Kinasha\nSimeon Mugisha", Toast.LENGTH_LONG).show();
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
