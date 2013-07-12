package com.tanzoft.habarihub;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockActivity;

public class SettingsActivity extends SherlockActivity implements
		OnClickListener {

	Spinner sUpdateFrequency;
	CheckBox cbAutoUpdate;
	CheckBox cbThumbnailImages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		sUpdateFrequency = (Spinner) findViewById(R.id.sUpdateFrequency);
		cbAutoUpdate = (CheckBox) findViewById(R.id.cbAutoUpdate);
		cbThumbnailImages = (CheckBox) findViewById(R.id.cbLoadThumbnails);

		populateSpinner();

	}

	public void populateSpinner() {
		// populate spinner with update frequency values from array.xml

		ArrayAdapter<CharSequence> fAdapter;
		fAdapter = ArrayAdapter.createFromResource(this,
				R.array.update_frequency, android.R.layout.simple_spinner_item);
		
		int spinner_dd_item = android.R.layout.simple_spinner_dropdown_item;
		fAdapter.setDropDownViewResource(spinner_dd_item);
		
		sUpdateFrequency.setAdapter(fAdapter);
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onClick(View view) {

	}

}
