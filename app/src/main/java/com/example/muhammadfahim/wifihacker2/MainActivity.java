package com.example.muhammadfahim.wifihacker2;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static com.example.muhammadfahim.wifihacker2.R.styleable.AlertDialog;

public class MainActivity extends AppCompatActivity
{
    ImageView wifi_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


;
        wifi_btn=(ImageView) findViewById(R.id.wifi_id);
        wifi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                    Intent i = new Intent(getApplicationContext(),Loading_page.class);
                    startActivity(i);




            }
        });



    }



    private void QuitApp(){

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Quit App")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }





    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
            QuitApp();
    }



}
