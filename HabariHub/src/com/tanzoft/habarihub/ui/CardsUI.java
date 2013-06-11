package com.tanzoft.habarihub.ui;

import android.app.Activity;
import android.os.Bundle;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.R;

public class CardsUI extends Activity {
    
    private CardUI card;
    private String RSSFEEDURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        //Bundle b = getIntent().getExtras();
        //RSSFEEDURL = (String) b.get("site");
        
        //DOMParser dp = new DOMParser();
        //RSSFeed fd = dp.parseXml(RSSFEEDURL);
        
        setContentView(R.layout.activity_cards);
        
        
        card = (CardUI)findViewById(R.id.cardsview);
        card.setSwipeable(false);
        
       
        
        //int count = fd.getItemCount();
        
        MyCard test = new MyCard("new cards");
        card.addCard(test);
        
        CardStack one = new CardStack();
        one.add(new MyCard("stack1"));
        one.add(new MyCard("stack2"));
        one.add(new MyCard("stack3"));
        one.add(new MyCard("stack4"));
        
        
        //for(int i=0; i < count; i++){
        //    RSSItem item = fd.getItem(i);
         //   card.addCard(new MyCard(item.getTitle()));
       // }
    }

}
