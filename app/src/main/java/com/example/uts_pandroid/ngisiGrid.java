package com.example.uts_pandroid;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ngisiGrid extends BaseAdapter {

    Context x;
    int gambar[];
    String judulMenu[];
    LayoutInflater tempel;

    public ngisiGrid(Context x, int[] gambar, String[] judulMenu) {
        this.x = x;
        this.gambar = gambar;
        this.judulMenu = judulMenu;
        tempel = (LayoutInflater.from(x));
    }

    @Override
    public int getCount() {
        return gambar.length;
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
        view = tempel.inflate(R.layout.mainisi, null);
        ImageView b =(ImageView) view.findViewById(R.id.ivGambar);
        TextView t = (TextView) view.findViewById(R.id.tvjudulMenu);

        b.setImageResource(gambar[i]);
        t.setText(judulMenu[i]);
        return view;
    }
}
