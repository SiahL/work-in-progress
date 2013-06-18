package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.ui.MyImageCard;

public class Developers extends SherlockActivity {

    private CardUI mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        mCardView = (CardUI) findViewById(R.id.cardsview);
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
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        case android.R.id.home:
            // app icon in action bar clicked; finish activity to go home
            finish();
            return true;

            // rate application
        case R.id.rate:
            String myUrl = "https://play.google.com/store/apps/details?id=com.tanzoft.habarihub";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
            break;

        case R.id.report:
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            /*
             * The intent does not have a URI, so declare the "text/plain" MIME
             * type, emailIntent.setType("text/plain");
             */
            emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {
                    "damas@tanzoft.com", "cmeo226@yahoo.com",
                    "pkinasha@gmail.com", "igotti47@gmail.com" }); // recipients
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Habari Hub Error");
            startActivity(Intent.createChooser(emailIntent,
                    "Choose Email Client"));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onPause() {
        super.onPause();
        finish();
    }

}
