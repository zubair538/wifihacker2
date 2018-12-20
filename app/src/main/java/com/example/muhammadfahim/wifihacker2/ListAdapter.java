package com.example.muhammadfahim.wifihacker2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
public class ListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<ScanResult> wifiList;

    public ListAdapter(Context context, List<ScanResult> wifiList) {
        this.context = context;
        this.wifiList = wifiList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return wifiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        System.out.println("viewpos" + position);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.dataset, null);
            holder = new Holder();
            holder.tvDetails = (TextView) view.findViewById(R.id.tvDetails);


            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.tvDetails.setText("" + wifiList.get(position).SSID);

        final String c_name = wifiList.get(position).SSID;

        final String pass = wifiList.get(position).BSSID;
        final int siganl_fre = wifiList.get(position).frequency;

        final String f_k = String.valueOf(siganl_fre);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Show_wifi.class);
                i.addFlags(FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("c_name", c_name);
                i.putExtra("password", pass);
                i.putExtra("sigan_freq", f_k);
                context.startActivity(i);
            }
        });


        return view;
    }

    public static int convertFrequencyToChannel(int freq) {
        if (freq >= 2412 && freq <= 2484) {
            return (freq - 2412) / 5 + 1;
        } else if (freq >= 5170 && freq <= 5825) {
            return (freq - 5170) / 5 + 34;
        } else {
            return -1;
        }
    }

    class Holder {
        TextView tvDetails;


    }
}