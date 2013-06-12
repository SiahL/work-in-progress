package com.tanzoft.habarihub;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends Activity {
	
	Button developers;
	Button github;
	Button paypal;

	@SuppressLint("NewApi")
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		developers = (Button)findViewById(R.id.button_developers);
		github = (Button)findViewById(R.id.button_github);
		paypal = (Button)findViewById(R.id.button_paypal);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		//open a web browser to developer's google+ page when button is pressed
		developers.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//url to developer's google+ page
			/*	String url = "https://plus.google.com/104081026859969508594/about";
				Intent plus = new Intent(Intent.ACTION_VIEW);
				plus.setData(Uri.parse(url));
				startActivity(plus);
				*/
			    
			    Intent dev =new Intent(AboutActivity.this, com.tanzoft.habarihub.Developers.class);
			    startActivity(dev);
				
			}
		});
		
		//open web browser to github source page
		github.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//url to github source page
				String url = "https://github.com/tanzoft/work-in-progress/tree/master/HabariHub";
				Intent gh = new Intent(Intent.ACTION_VIEW);
				gh.setData(Uri.parse(url));
				startActivity(gh);
				
			}
		});
		
		paypal.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
               
                
            }
        });
	}
	
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        case android.R.id.home:
            // app icon in action bar clicked; finish activity to go home
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    //kill activity when it goes in the background
    public void onPause(){
        super.onPause();
        finish();
    }

}
