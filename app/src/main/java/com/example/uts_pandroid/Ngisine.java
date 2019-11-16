package com.example.uts_pandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Ngisine extends BaseAdapter {

    Context x;
    String kode[];
    String nama[];
    String satuan[];
    String hargabeli[];
    String hargajual[];
    String diskon[];
    LayoutInflater y;

    public Ngisine(Context x, String kode[], String nama[], String satuan[], String hargabeli[], String hargajual[], String diskon[]){
        this.x = x;
        this.kode = kode;
        this.nama = nama;
        this.satuan = satuan;
        this.hargabeli = hargabeli;
        this.hargajual = hargajual;
        this.diskon = diskon;
        y = (LayoutInflater.from(x));
    }

    @Override
    public int getCount() {
        return kode.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =y.inflate(R.layout.listview, null);
        TextView kode1=(TextView)view.findViewById(R.id.Kode);
        TextView nama1=(TextView)view.findViewById(R.id.Nama);
        TextView satuan1=(TextView)view.findViewById(R.id.Satuan);
        TextView hargabeli1=(TextView)view.findViewById(R.id.HargaBeli);
        TextView hargajual1=(TextView)view.findViewById(R.id.HargaJual);
        TextView diskon1=(TextView)view.findViewById(R.id.Diskon);
        kode1.setText(kode[i]);
        nama1.setText(nama[i]);
        satuan1.setText(satuan[i]);
        hargabeli1.setText(hargabeli[i]);
        hargajual1.setText(hargajual[i]);
        diskon1.setText(diskon[i]);
        return view;
    }
}
