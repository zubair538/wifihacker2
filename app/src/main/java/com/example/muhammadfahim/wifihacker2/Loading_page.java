package com.example.muhammadfahim.wifihacker2;

/**
 * Created by Muhammad Fahim on 7/10/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


/**

 */

public class Loading_page extends AppCompatActivity {


    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mProgressStatus = 0;


    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);



        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
        mLoadingText = (TextView) findViewById(R.id.LoadingCompleteTextView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //////////got to wifi connection class
                        mLoadingText.setVisibility(View.VISIBLE);
                        Intent i=new Intent(getApplicationContext(),Wifi_Con.class);
                        startActivity(i);
                    }
                });
            }

        }).start();


    }



    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub




            Intent intent = new Intent(Loading_page.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);



    }



}
