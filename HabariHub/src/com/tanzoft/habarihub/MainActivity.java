package com.tanzoft.habarihub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.fima.cardsui.views.CardUI;
import com.tanzoft.habarihub.ui.MyPlayCard;

public class MainActivity extends Activity {

    CardUI mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        mCardView = (CardUI) findViewById(R.id.cardsview);
        mCardView.setSwipeable(false);

        MyPlayCard blogs = new MyPlayCard("Blogs and Sites",
                "Your gateway to latest news from TZ finest", "#e00707",
                "#e00707", false, false);

        blogs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent blog = new Intent(MainActivity.this,
                        com.tanzoft.habarihub.BlogsActivity.class);
                startActivity(blog);

            }
        });
        mCardView.addCard(blogs);

        MyPlayCard newspapers = new MyPlayCard("Newspapers",
                "Preview latest headlines.", "#e00707", "#e00707", false, false);

        newspapers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent news = new Intent(MainActivity.this,
                        com.tanzoft.habarihub.MagazetiActivity.class);
                startActivity(news);

            }
        });
        mCardView.addCard(newspapers);

        MyPlayCard radios = new MyPlayCard("Radio", "Radio on the go!!",
                "#e00707", "#33B5E5", false, false);

        radios.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent radio = new Intent(MainActivity.this,
                        com.tanzoft.habarihub.RadioActivity.class);
                startActivity(radio);

            }
        });
        mCardView.addCard(radios);

        MyPlayCard videos = new MyPlayCard("Videos", "TZ Videos on youtube",
                "#e00707", "#33B5E5", false, false);

        videos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent video = new Intent(MainActivity.this,
                        com.tanzoft.habarihub.VideosActivity.class);
                startActivity(video);

            }
        });
        mCardView.addCard(videos);

        MyPlayCard about = new MyPlayCard("About Us", "Know Us. Meet Us.",
                "#e00707", "#e00707", false, false);

        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent abt = new Intent(MainActivity.this,
                        com.tanzoft.habarihub.AboutActivity.class);
                startActivity(abt);

            }
        });
        mCardView.addCard(about);

        mCardView.refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
