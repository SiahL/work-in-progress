package com.tanzoft.seandayo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spash_screen);
		
		//
		Thread timer = new Thread(){
			
			public void run(){
				try{
					//Pause splash screen for 5 seconds, then load main activity
					sleep(3200);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					//call activity by Intents
					Intent openMain = new Intent("com.tanzoft.SeanDayo.MAINACTIVITY");
					startActivity(openMain);
				}
			}
			
		};
		timer.start();
	}

	@Override
	
	//when splash goes into background(onPause()), kill activity
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
