package com.tanzoft.habarihub;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class RadioActivity extends SherlockListActivity {

    final List<String[]> radioList = new LinkedList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // radioList.add(new String[] { "Clouds FM", "The People's Station", ""
        // });
        radioList.add(new String[] { "Capital Radio", "Fahari ya Msikilizaji",
                "http://78.129.232.75:8066" });
        radioList.add(new String[] { "East Africa Radio",
                "Together Tunawakilisha", "http://173.192.70.138:8270" });
        /*
         * radioList.add(new String[] { "Ebony", "Feel the Difference",
         * "http://198.154.106.102:8451/stream" });
         * radioList.add(new String[] { "Radio Kwizera", "Jukwaa la Matumaini",
         * "http://67.212.166.210:8402/live" });
         * radioList.add(new String[] { "Wapo Radio", "",
         * "http://69.175.127.154:9062/stream" });
         * radioList.add(new String[] { "QibLaten", "Sauti ya Hekima",
         * "http://69.175.33.162:8203/stream" });
         */
        radioList.add(new String[] { "Radio One", "",
                "http://78.129.232.75:8119" });
        /*
         * radioList.add(new String[] { "Magic FM",
         * "Believe in the Power of Magic", "" });
         * radioList.add(new String[] { "Radio Kheri", "",
         * "http://108.166.161.206:8737/stream" });
         * radioList.add(new String[] { "Times FM", "Experience Africa",
         * "http://41.216.220.75:8000/Timesfm" });
         * // radioList.add(new String[] { "Country FM", "One Community", "" });
         * radioList.add(new String[] { "HHC Alive FM", "Sauti ya Tumaini",
         * "http://188.165.58.191:13976/" });
         * radioList.add(new String[] { "Info Radio", "",
         * "http://69.175.33.162:8216/stream" });
         */
        radioList.add(new String[] { "Radio Mbao", "",
                "http://173.192.70.138:8040" });
        radioList.add(new String[] { "Bongo Radio", "",
                "http://198.105.215.28:8000/bongo.mp3" });
        /*
         * radioList.add(new String[] { "Radio Maria",
         * "A Christian Voice in Your Home", "" });
         * radioList.add(new String[] { "Radio One", "", "" });
         * radioList.add(new String[] { "TBC FM", "", "" });
         * radioList.add(new String[] { "Radio Free Africa",
         * "The Sound Of Africa", "" });
         * radioList.add(new String[] { "Lutheran Radio Center", "", "" });
         * radioList.add(new String[] { "Radio Safina", "", "" });
         * radioList.add(new String[] { "Mbeya Highlands FM", "", "" });
         * radioList.add(new String[] { "Bongo Radio", "", "" });
         * radioList.add(new String[] { "VCC Radio", "", "" });
         * radioList.add(new String[] { "RFI Swahili", "", "" });
         */

        setListAdapter(new ArrayAdapter<String[]>(RadioActivity.this,
                android.R.layout.simple_list_item_2, android.R.id.text1,
                radioList) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String[] entry = radioList.get(position);
                TextView text1 = (TextView) view
                        .findViewById(android.R.id.text1);
                // text1.setTextColor(Color.BLACK);
                TextView text2 = (TextView) view
                        .findViewById(android.R.id.text2);
                // text2.setTextColor(Color.BLACK);
                text1.setText(entry[0]);
                text2.setText(entry[1]);
                return view;
            }
        });

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        String[] channel = radioList.get(position);
        Intent playRadio = new Intent(RadioActivity.this, MediaActivity.class);
        playRadio.putExtra("MediaActivity", channel[2]);
        startActivity(playRadio);
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

    // Kill activity when it goes to background
    public void onPause() {
        super.onPause();
    }

}
