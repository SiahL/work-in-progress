package com.tanzoft.habarihub.fragments;

import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.HabariHubMainActivity;
import com.tanzoft.habarihub.R;
import com.tanzoft.habarihub.cards.MyPlayCard;
import com.tanzoft.habarihub.extendedviews.HabariHubTextView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutUsFragment extends HabariHubFragmentHandler {

	HabariHubTextView tv;
	CardUI aboutCards;
	String color;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		color="#0ab0e8";
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.about_us_fragment,container, false);
		tv=(HabariHubTextView)view.findViewById(R.id.title);

		((HabariHubMainActivity)getActivity()).getSupportActionBar().setTitle("About Us");

		// cards UI
		aboutCards = (CardUI) view.findViewById(R.id.about_cards);
		aboutCards.setSwipeable(false);

		// CardStack dev = new CardStack();
		// dev.setTitle("Developers Info and Stuffs");
		// aboutCards.addStack(dev);

		MyPlayCard developers = new MyPlayCard("Developers",
				"People behind this app",color,color, false, false);

		developers.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				/*Intent devs = new Intent(getActivity(),com.tanzoft.habarihub.Developers.class);
				startActivity(devs);*/

				HabariHubFragmentHandler fragment = new DevelopersFragment();
				startBackStackedFragment(fragment, (HabariHubMainActivity) getActivity());
			}
		});

		aboutCards.addCard(developers);

		MyPlayCard github = new MyPlayCard("Source Code at Github",
				"Fork me at github", color, color, false, false);

		github.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
						
				// url to github source page
				String url = "https://github.com/tanzoft/work-in-progress";
				Intent gh = new Intent(Intent.ACTION_VIEW);
				gh.setData(Uri.parse(url));
				startActivity(gh);
			}
		});

		aboutCards.addCard(github);


		MyPlayCard credits = new MyPlayCard("Credits", "Our special thanks",
				color,color, false, false);
		credits.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			/*	Intent cred = new Intent(getActivity(), com.tanzoft.habarihub.CreditsActivity.class);
				startActivity(cred);*/
				
				HabariHubFragmentHandler fragment = new CreditsFragment();
				startBackStackedFragment(fragment, (HabariHubMainActivity) getActivity());

			}
		});
		aboutCards.addCard(credits);

		aboutCards.refresh();
	
	return view;
}
@Override
public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	
}

@Override
public void onStart() {
	super.onStart();
}


@Override
public void onResume() {
	super.onResume();
}

@Override
public void onPause() {
	super.onPause();
}


@Override
public void onStop() {
	super.onStop();
}

@Override
public void onDestroyView() {
	super.onDestroyView();
}

@Override
public void onDestroy() {
	super.onDestroy();
}



@Override
public void onDetach() {
	super.onDetach();
}







}
