package com.tanzoft.habarihub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tanzoft.habarihub.adapters.HabariHubDrawerAdapter;
import com.tanzoft.habarihub.fragments.FragmentView;
import com.tanzoft.habarihub.fragments.HabariHubFragmentHandler;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HabariHubMainActivity extends ActionBarActivity {


	private String[] mDrawerOptions; //an array of string that will hold the names of the options for the drawer
	private DrawerLayout mDrawerLayout;//a java object for the whole drawer layout view
	private ListView mDrawerList; //a list view object for the list view options
	private LinearLayout mDrawer;//A java object for the left drawer
	private ActionBarDrawerToggle mDrawerToggle; //toggle button for drawer toggle
	private List<HashMap<String,String>> mList;//a list of hash maps to hold mapped images and left drawer options
	private HabariHubDrawerAdapter mAdapter; //a custom adapter to adapt the list views on the left drawer
	final private String OPTION = "option"; //a key for each options from the array of options
	String mTitle=" ";//title for the action bar
	int mPosition=-1;//an integer to check the row position of list views;position starts at zero




	//Array of integers pointing to the icons stored in /res/drawable


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*setting the whole drawerLayout */

		//Getting an array of options from resources 
		mDrawerOptions = getResources().getStringArray(R.array.drawerMenu);
		//Title of the Activity
		mTitle= (String) getTitle();
		//Getting a reference to DrawerLayout
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//Getting a reference to the drawer listview
		mDrawerList = (ListView) findViewById(R.id.drawer_list);
		//Getting a reference to the sidebar drawer
		mDrawer = (LinearLayout) findViewById(R.id.left_drawer);


		//Each row in the list stores an option which is a HashMap text
		mList = new ArrayList<HashMap<String,String>>();

		for (int i=0;i<5;++i){
			HashMap<String, String> hm = new HashMap<String, String>();//HashMap object
			hm.put(OPTION, mDrawerOptions[i]);//putting the respective option to HashMap
			mList.add(hm);//adding HashMap into array List
		}

		//Keys used in HashMap
		String[] from = {OPTION};

		//Ids of views in listviewLayout
		int[] to ={R.id.drawerOption};

		//Instatiating an adapter to store each items
		//R.layout.drawer_layout defines the layout of each item
		mAdapter = new HabariHubDrawerAdapter (this, mList, R.layout.drawer_layout, from, to);//Mapping each HashMap to a ListView

		//Setting the adapter to the listView
		mDrawerList.setAdapter(mAdapter);

		//Creating a ToggleButton for NavigationDrawer
		mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close){


			//called when drawer is opened
			public void onDrawerClosed(View view){
				highlightSelectedOption();
				supportInvalidateOptionsMenu();
			}

			//Called when a drawer is opened
			public void onDrawerOpened(View drawerView){
				getSupportActionBar().setTitle("Habari Hub");
				supportInvalidateOptionsMenu();
			}
		};

		//Setting event listener for the drawer
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		//ItemClick event handler for the drawer items
		mDrawerList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {

				//Closing the Drawer
				mDrawerLayout.closeDrawer(mDrawer);

				switch (pos){

				case 0:

					showFragment(pos);
					break;

				case 1:
					showFragment(pos);
					break;

				case 2:
					showFragment(pos);
					break;

				case 3 :
					showFragment(pos);
					break;

				case 4:
					showFragment(pos);					
					break;
				}


			}

		});


		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setDisplayShowHomeEnabled(true);






	}


	@Override
	protected void onPostCreate(Bundle savedInstanceState){
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item){

		if (mDrawerToggle.onOptionsItemSelected(item)){
			return true;
		}

		return super.onOptionsItemSelected(item);
	}



	//Highlight the selected option 0 to 4
	protected void highlightSelectedOption() {
		// TODO Auto-generated method stub
		int selectedItem = mDrawerList.getCheckedItemPosition();
		if (selectedItem > 4){

			mDrawerList.setItemChecked(mPosition, true);

		}else{

			mPosition = selectedItem;
		}

		if(mPosition !=-1){
			getSupportActionBar().setTitle(mDrawerOptions[mPosition]);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	public void showFragment(int position){

		//Currently selected country
		mTitle = mDrawerOptions[position];	

		// Creating a fragment object
		HabariHubFragmentHandler hFragment = new FragmentView();

		// Creating a Bundle object
		Bundle data = new Bundle();

		// Setting the index of the currently selected item of mDrawerList
		data.putInt("position", position);

		// Setting the position to the fragment

		hFragment.setArguments(data);

		// Getting reference to the FragmentManager
		FragmentManager fragmentManager  = getSupportFragmentManager();

		// Creating a fragment transaction
		FragmentTransaction ft = fragmentManager.beginTransaction();

		// Adding a fragment to the fragment transaction
		// ft.replace(R.id.content_frame, oFragment);
		ft.replace(R.id.content_frame,hFragment);


		// Committing the transaction
		ft.commit();
	}


	/*private  void executeFragment(final FragmentHandler fragment) {

	//DrawerLayout.closeDrawer(mDrawer);
	//ew Handler().postDelayed(new Runnable() {

			//verride
		//ublic void run() {
				// TODO Auto-generated method stub

				// Creating a Bundle object
				Bundle data = new Bundle();

				// Setting the position to the fragment

				fragment.setArguments(data);

				// Getting reference to the FragmentManager
				FragmentManager fragmentManager  = getSupportFragmentManager();

				// Creating a fragment transaction
				FragmentTransaction ft = fragmentManager.beginTransaction();

				// Adding a fragment to the fragment transaction
				ft.replace(R.id.content_frame,fragment);

				// Committing the transaction
				ft.commit();

	//}
	//, 200);

	}*/






}
