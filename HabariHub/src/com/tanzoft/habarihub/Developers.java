package com.tanzoft.habarihub;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.ui.MyImageCard;

public class Developers extends Activity {

    private CardUI mCardView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mCardView = (CardUI) findViewById(R.id.cardsview);
        // cards cannot be swiped away as in google now, set true to make cards
        // swipeable
        mCardView.setSwipeable(false);

        // create Image card for each developer
        MyImageCard damas = new MyImageCard("Damas Mlabwa", R.drawable.damas);
        mCardView.addCard(damas);

        MyImageCard newton = new MyImageCard("Newton Bujiku", R.drawable.newton);
        mCardView.addCard(newton);

        MyImageCard philip = new MyImageCard("Philip Kinasha",
                R.drawable.philip);
        mCardView.addCard(philip);

        MyImageCard simeon = new MyImageCard("Simeon Mugisha",
                R.drawable.simeon);
        mCardView.addCard(simeon);

        // draw cards
        mCardView.refresh();
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

    // when activity goes to background kill activity
    public void pause() {
        super.onPause();
        finish();
    }

}
