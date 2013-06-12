package com.tanzoft.habarihub;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.ui.MyImageCard;

public class Developers extends Activity {

    private CardUI mCardView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        mCardView = (CardUI)findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);
        
        
        MyImageCard damas = new MyImageCard("Damas Mlabwa", R.drawable.damas);
        mCardView.addCard(damas);
        
        MyImageCard newton = new MyImageCard("Newton Bujiku", R.drawable.newton);
        mCardView.addCard(newton);
        
        MyImageCard philip = new MyImageCard("Philip Kinasha", R.drawable.philip);
        mCardView.addCard(philip);
        
        MyImageCard simeon = new MyImageCard("Simeon Mugisha", R.drawable.simeon);
        mCardView.addCard(simeon);
       
        mCardView.refresh();
    }
    

}
