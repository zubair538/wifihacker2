package com.example.muhammadfahim.wifihacker2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Show_wifi extends AppCompatActivity
{
    String final_lastC=null;
    String c_name,pass,frequency;
    TextView con_name,fre_level,password,uper_pass;
    String final_password="";
    String[] parts;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);


        Intent i=getIntent();
        c_name=i.getStringExtra("c_name");
        pass=i.getStringExtra("password");
        frequency=i.getStringExtra("sigan_freq");

        con_name=(TextView) findViewById(R.id.con_id);
        fre_level=(TextView) findViewById(R.id.fre_id);
        password=(TextView) findViewById(R.id.pass_id);
        uper_pass=(TextView)findViewById(R.id.uper_id);
        if(pass.length()!=0)
            parts = pass.split(":");

        int k=parts.length;
        String lastdigit=parts[k-1];
        char first = lastdigit.charAt(1);
        char last = lastdigit.charAt(0);
        String last_chr=String.valueOf(first);
        String first_chr=String.valueOf(last);


        // Toast.makeText(getApplicationContext(),last_chr,Toast.LENGTH_LONG).show();

        if(last_chr.equals("0"))
        {
            final_lastC="f";
        }
        else if(last_chr.equals("1"))
        {
            final_lastC="0";
        }
        else if(last_chr.equals("2"))
        {
            final_lastC="1";
        }
        else if(last_chr.equals("3"))
        {
            final_lastC="2";
        }
        else if(last_chr.equals("4"))
        {
            final_lastC="3";
        }
        else if(last_chr.equals("5"))
        {
            final_lastC="4";
        }
        else if(last_chr.equals("6"))
        {
            final_lastC="5";
        }
        else if(last_chr.equals("7"))
        {
            final_lastC="6";
        }
        else if(last_chr.equals("8"))
        {
            final_lastC="7";
        }
        else if(last_chr.equals("9"))
        {
            final_lastC="8";
        }
        else if(last_chr.equals("a") || last_chr.equals("A"))
        {
            final_lastC="9";
        }
        else if(last_chr.equals("b") || last_chr.equals("B"))
        {
            final_lastC="a";
        }
        else if(last_chr.equals("c") || last_chr.equals("C"))
        {
            final_lastC="b";
        }
        else if(last_chr.equals("d") || last_chr.equals("D"))
        {
            final_lastC="c";
        }
        else if(last_chr.equals("e") || last_chr.equals("E"))
        {
            final_lastC="d";
        }
        else if(last_chr.equals("f") || last_chr.equals("F"))
        {
            final_lastC="e";
        }


        for (int j=2;j<k-1;j++)
        {
            final_password=final_password+parts[j];
        }
        final_password=final_password+first_chr+final_lastC;

        // Toast.makeText(getApplicationContext(),final_password,Toast.LENGTH_LONG).show();

        con_name.setText("Connection Name: "+c_name);
        fre_level.setText("Frequancy: "+frequency+" Hz");
        String upper=final_password.toUpperCase();
        password.setText("Password 1: "+final_password);
        uper_pass.setText("Password 2: "+upper);
        //Toast.makeText(getApplicationContext(),upper,Toast.LENGTH_LONG).show();

        // Toast.makeText(getApplicationContext(),c_name+":"+pass+":"+frequency,Toast.LENGTH_LONG).show();


    }


    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

            Intent intent = new Intent(Show_wifi.this,Wifi_Con.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);



    }



}
