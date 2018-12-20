package com.example.muhammadfahim.wifihacker2;


import java.util.List;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;



public class Wifi_Con extends Activity {
    private WifiManager mainWifi;
    private WifiReceiver receiverWifi;
    private ImageView btnRefresh;
    ListAdapter adapter;
    ListView lvWifiDetails;
    List wifiList;

    private AppCompatDelegate mDelegate;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);
        setContentView(R.layout.wifi_con);

        setupActionBar();
////button defineation
        lvWifiDetails = (ListView) findViewById(R.id.lvWifiDetails);
        btnRefresh = (ImageView) findViewById(R.id.btnRefresh);

        ///wificheck wifi sercises
        mainWifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        receiverWifi = new WifiReceiver();
        ////scann wifi
        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        scanWifiList();
        ///refersh button
        btnRefresh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                scanWifiList();
            }
        });
////////////give detail of wifi when click on wifi
        lvWifiDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i= new Intent(getApplicationContext(),Show_wifi.class);
                startActivity(i);
            }
        });
    }
    /////call adadaptor class of the recyclerview
    private void setAdapter() {
        adapter = new ListAdapter(getApplicationContext(), wifiList);
        lvWifiDetails.setAdapter(adapter);
    }
    private void scanWifiList()
    {
        mainWifi.startScan();
        wifiList = mainWifi.getScanResults();
        setAdapter();
    }
    class WifiReceiver extends BroadcastReceiver
    {
        public void onReceive(Context c, Intent intent)
        {
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }
///////////on back press go to main activity
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

            Intent intent = new Intent(Wifi_Con.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }




}
