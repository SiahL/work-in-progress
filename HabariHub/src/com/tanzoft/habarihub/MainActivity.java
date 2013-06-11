package com.tanzoft.habarihub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button blogs;
	Button magazeti;
	Button radio;
	Button about;
	Button social;
	Button videos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//sections of the app, all list views except radio
		blogs = (Button)findViewById(R.id.blogs);
		magazeti=(Button)findViewById(R.id.magazeti);
		radio=(Button)findViewById(R.id.radio);
		about=(Button)findViewById(R.id.about);
		social=(Button)findViewById(R.id.social);
		videos=(Button)findViewById(R.id.videos);
		
		about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent about = new Intent(MainActivity.this,AboutActivity.class);
				startActivity(about);
				
			}
		});
		
		blogs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent blogs = new Intent(MainActivity.this, BlogsActivity.class);
				startActivity(blogs);
				
			}
		});
		
		magazeti.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent magazeti = new Intent(MainActivity.this, MagazetiActivity.class);
				startActivity(magazeti);
				
			}
		});
		
		radio.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent radio = new Intent(MainActivity.this, RadioActivity.class);
				startActivity(radio);
				
			}
		});
		
		videos.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent video = new Intent(MainActivity.this, VideosActivity.class);
                startActivity(video);
                
            }
        });
		
		social.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent social = new Intent(MainActivity.this, SocialActivity.class);
                startActivity(social);
                
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
