package com.tanzoft.habarihub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends Activity {
	
	Button gplus;
	Button github;
	Button paypal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		gplus = (Button)findViewById(R.id.button_gplus);
		github = (Button)findViewById(R.id.button_github);
		paypal = (Button)findViewById(R.id.button_paypal);
		
		//open a web browser to developer's google+ page when button is pressed
		gplus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//url to developer's google+ page
				String url = "https://plus.google.com/104081026859969508594/about";
				Intent plus = new Intent(Intent.ACTION_VIEW);
				plus.setData(Uri.parse(url));
				startActivity(plus);
				
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
	}

}
