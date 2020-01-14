package com.example.uts_pandroid;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_Utama extends AppCompatActivity {

    GridView gv;
    int gambar[] = {R.drawable.ic_supplier,R.drawable.ic_barang, R.drawable.ic_karyawan, R.drawable.ic_beli,R.drawable.ic_jual,R.drawable.ic_stock, R.drawable.ic_lap_beli, R.drawable.ic_lap_jual};
    String judul[] = {"Supplier", "Barang", "Karyawan", "Beli", "Jual", "Laporan Stok", "Laporan Beli", "Laporan Jual"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__utama);

        gv = (GridView)findViewById(R.id.isiKonten);
        ngisiGrid xxx = new ngisiGrid(getApplication(),gambar, judul);
        gv.setAdapter(xxx);
    }
}
