package com.tanzoft.habarihub.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.HabariHubMainActivity;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.cards.MyImageCard;

public class DevelopersFragment extends HabariHubFragmentHandler {

	CardUI mCardView;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	((HabariHubMainActivity)getActivity()).getSupportActionBar().setTitle("Developers");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.developers_fragment, container, false);
		
		mCardView = (CardUI) view.findViewById(R.id.cardsview);
		// cards cannot be swiped away as in google now, set true to make cards
		// swipeable
		mCardView.setSwipeable(false);

		// create Image card for each developer
		MyImageCard damas = new MyImageCard("Damas Mlabwa", R.drawable.damas);
		damas.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// url to developer's google+ page
				String url = "https://plus.google.com/104081026859969508594/about";
				Intent plus = new Intent(Intent.ACTION_VIEW);
				plus.setData(Uri.parse(url));
				startActivity(plus);

			}
		});
		mCardView.addCard(damas);

		// Newton card
		MyImageCard newton = new MyImageCard("Newton Bujiku", R.drawable.newton);
		newton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// url to developer's google+ page
				String url = "https://plus.google.com/106580479646612714057/about";
				Intent plus = new Intent(Intent.ACTION_VIEW);
				plus.setData(Uri.parse(url));
				startActivity(plus);

			}
		});
		mCardView.addCard(newton);

		// Philip card
		MyImageCard philip = new MyImageCard("Philip Kinasha",
				R.drawable.philip);
		philip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// url to developer's google+ page
				String url = "https://plus.google.com/100250468248307344507/about";
				Intent plus = new Intent(Intent.ACTION_VIEW);
				plus.setData(Uri.parse(url));
				startActivity(plus);

			}
		});
		mCardView.addCard(philip);

		// Simeon card
		MyImageCard simeon = new MyImageCard("Simeon Mugisha",
				R.drawable.simeon);
		simeon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// url to developer's google+ page
				String url = "https://plus.google.com/106366345061442881202/about";
				Intent plus = new Intent(Intent.ACTION_VIEW);
				plus.setData(Uri.parse(url));
				startActivity(plus);

			}
		});
		mCardView.addCard(simeon);

		// draw cards
		mCardView.refresh();
		
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDestroyOptionsMenu() {
		super.onDestroyOptionsMenu();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
	}


}
