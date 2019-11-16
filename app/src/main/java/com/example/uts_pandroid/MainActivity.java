package com.example.uts_pandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

//    inisialisasi setting variabel
    static String dbname="stok.db";
    EditText kode, nama, satuan, hbeli, hjual, diskon;
    Button simpan, update, delete, clear;
    ListView isilist;
    SQLiteDatabase db;
    String kd, nm, st, hb, hj, dsk;
    int x;
    String kode11[];
    String nama11[];
    String satuan11[];
    String hbeli11[];
    String hjual11[];
    String diskon11[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        manggil di activity_main.xml edtitext dkk
        kode = (EditText)findViewById(R.id.etKode);
        nama = (EditText)findViewById(R.id.etNama);
        satuan = (EditText)findViewById(R.id.etSatuan);
        hbeli = (EditText)findViewById(R.id.etHargaBeli);
        hjual = (EditText)findViewById(R.id.etHargaJual);
        diskon = (EditText)findViewById(R.id.etDiskon);
        isilist = (ListView)findViewById(R.id.isi);

        simpan = (Button)findViewById(R.id.btnSimpan);
        update = (Button)findViewById(R.id.btnUpdate);
        delete = (Button)findViewById(R.id.btnHapus);
        clear = (Button)findViewById(R.id.btnClear);

//        munculno data
        db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select * from barang", null);
        kode11 = new String[c.getCount()];
        nama11 = new String[c.getCount()];
        satuan11 = new String[c.getCount()];
        hbeli11 = new String[c.getCount()];
        hjual11 = new String[c.getCount()];
        diskon11 = new String[c.getCount()];
        x=1;
        c.moveToFirst();
        kode11[0] = c.getString(c.getColumnIndex("kode"));
        nama11[0] = c.getString(c.getColumnIndex("nama"));
        satuan11[0] = c.getString(c.getColumnIndex("satuan"));
        hbeli11[0] = c.getString(c.getColumnIndex("hbeli"));
        hjual11[0] = c.getString(c.getColumnIndex("hjual"));
        diskon11[0] = c.getString(c.getColumnIndex("diskon"));
        while(c.moveToNext()){
            kode11[x] = c.getString(c.getColumnIndex("kode"));
            nama11[x] = c.getString(c.getColumnIndex("nama"));
            satuan11[x] = c.getString(c.getColumnIndex("satuan"));
            hbeli11[x] = c.getString(c.getColumnIndex("hbeli"));
            hjual11[x] = c.getString(c.getColumnIndex("hjual"));
            diskon11[x] = c.getString(c.getColumnIndex("diskon"));
            x = x+1;
        }
        db.close();
        Ngisine xx = new Ngisine(getApplication(),kode11, nama11, satuan11, hbeli11, hjual11, diskon11);
        isilist.setAdapter(xx);
//munculno data akhir

//        tombol simpan
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//           buka database
            db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);
//            create database (membuat)
            db.execSQL("CREATE table if not exists barang(kode varchar(20), nama varchar(20), satuan varchar(100),hbeli varchar(100), hjual varchar(100), diskon varchar(100));");

//            masukkan nilai yang ada di edittext
            kd = kode.getText().toString();
            nm = nama.getText().toString();
            st = satuan.getText().toString();
            hb = hbeli.getText().toString();
            hj = hjual.getText().toString();
            dsk = diskon.getText().toString();

//            insert data ke database
            db.execSQL("insert into barang values('"+ kd+"','"+ nm +"','"+ st +"','"+ hb +"','"+ hj +"','"+ dsk +"');");
//            cursor
            Cursor c = db.rawQuery("select * from barang", null);
                kode11 = new String[c.getCount()];
                nama11 = new String[c.getCount()];
                satuan11 = new String[c.getCount()];
                hbeli11 = new String[c.getCount()];
                hjual11 = new String[c.getCount()];
                diskon11 = new String[c.getCount()];
                x=1;
                    c.moveToFirst();
                kode11[0] = c.getString(c.getColumnIndex("kode"));
                nama11[0] = c.getString(c.getColumnIndex("nama"));
                satuan11[0] = c.getString(c.getColumnIndex("satuan"));
                hbeli11[0] = c.getString(c.getColumnIndex("hbeli"));
                hjual11[0] = c.getString(c.getColumnIndex("hjual"));
                diskon11[0] = c.getString(c.getColumnIndex("diskon"));
                while(c.moveToNext()){
                    kode11[x] = c.getString(c.getColumnIndex("kode"));
                    nama11[x] = c.getString(c.getColumnIndex("nama"));
                    satuan11[x] = c.getString(c.getColumnIndex("satuan"));
                    hbeli11[x] = c.getString(c.getColumnIndex("hbeli"));
                    hjual11[x] = c.getString(c.getColumnIndex("hjual"));
                    diskon11[x] = c.getString(c.getColumnIndex("diskon"));
                x = x+1;
                }
                db.close();
                Ngisine xx = new Ngisine(getApplication(),kode11, nama11, satuan11, hbeli11, hjual11, diskon11);
                isilist.setAdapter(xx);
                update.setEnabled(true);
                delete.setEnabled(true);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);

                kd = kode.getText().toString();
                nm = nama.getText().toString();
                st = satuan.getText().toString();
                hb = hbeli.getText().toString();
                hj = hjual.getText().toString();
                dsk = diskon.getText().toString();

                db.execSQL("update barang set nama = '"+ nm +"',satuan = '"+ st +"', hbeli = '"+ hb +"', hjual = '"+ hj +"', diskon = '"+ dsk +"' where kode = '"+ kd +"';");
                Cursor c = db.rawQuery("select * from barang", null);
                kode11 = new String[c.getCount()];
                nama11 = new String[c.getCount()];
                satuan11 = new String[c.getCount()];
                hbeli11 = new String[c.getCount()];
                hjual11 = new String[c.getCount()];
                diskon11 = new String[c.getCount()];
                x=1;
                c.moveToFirst();
                kode11[0] = c.getString(c.getColumnIndex("kode"));
                nama11[0] = c.getString(c.getColumnIndex("nama"));
                satuan11[0] = c.getString(c.getColumnIndex("satuan"));
                hbeli11[0] = c.getString(c.getColumnIndex("hbeli"));
                hjual11[0] = c.getString(c.getColumnIndex("hjual"));
                diskon11[0] = c.getString(c.getColumnIndex("diskon"));
                while(c.moveToNext()){
                    kode11[x] = c.getString(c.getColumnIndex("kode"));
                    nama11[x] = c.getString(c.getColumnIndex("nama"));
                    satuan11[x] = c.getString(c.getColumnIndex("satuan"));
                    hbeli11[x] = c.getString(c.getColumnIndex("hbeli"));
                    hjual11[x] = c.getString(c.getColumnIndex("hjual"));
                    diskon11[x] = c.getString(c.getColumnIndex("diskon"));
                    x = x+1;
                }
                db.close();
                Ngisine xx = new Ngisine(getApplication(),kode11, nama11, satuan11, hbeli11, hjual11, diskon11);
                isilist.setAdapter(xx);
                update.setEnabled(false);
                delete.setEnabled(false);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);

                kd = kode.getText().toString();
                nm = nama.getText().toString();
                st = satuan.getText().toString();
                hb = hbeli.getText().toString();
                hj = hjual.getText().toString();
                dsk = diskon.getText().toString();

                db.execSQL("delete from barang where kode = '"+ kd +"';");
                Cursor c = db.rawQuery("select * from barang", null);
                kode11 = new String[c.getCount()];
                nama11 = new String[c.getCount()];
                satuan11 = new String[c.getCount()];
                hbeli11 = new String[c.getCount()];
                hjual11 = new String[c.getCount()];
                diskon11 = new String[c.getCount()];
                x=1;
                c.moveToFirst();
                kode11[0] = c.getString(c.getColumnIndex("kode"));
                nama11[0] = c.getString(c.getColumnIndex("nama"));
                satuan11[0] = c.getString(c.getColumnIndex("satuan"));
                hbeli11[0] = c.getString(c.getColumnIndex("hbeli"));
                hjual11[0] = c.getString(c.getColumnIndex("hjual"));
                diskon11[0] = c.getString(c.getColumnIndex("diskon"));
                while(c.moveToNext()){
                    kode11[x] = c.getString(c.getColumnIndex("kode"));
                    nama11[x] = c.getString(c.getColumnIndex("nama"));
                    satuan11[x] = c.getString(c.getColumnIndex("satuan"));
                    hbeli11[x] = c.getString(c.getColumnIndex("hbeli"));
                    hjual11[x] = c.getString(c.getColumnIndex("hjual"));
                    diskon11[x] = c.getString(c.getColumnIndex("diskon"));
                    x = x+1;
                }
                db.close();
                Ngisine xx = new Ngisine(getApplication(),kode11, nama11, satuan11, hbeli11, hjual11, diskon11);
                isilist.setAdapter(xx);
                update.setEnabled(false);
                delete.setEnabled(false);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kode.setText("");
                nama.setText("");
                satuan.setText("");
                hjual.setText("");
                hbeli.setText("");
                diskon.setText("");
                update.setEnabled(false);
                delete.setEnabled(false);
            }
        });

        isilist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, kode11[i], Toast.LENGTH_SHORT).show();
                kode.setText(kode11[i]);
                nama.setText(nama11[i]);
                satuan.setText(satuan11[i]);
                hbeli.setText(hbeli11[i]);
                hjual.setText(hjual11[i]);
                diskon.setText(diskon11[i]);
                update.setEnabled(true);
                delete.setEnabled(true);
            }
        });

    }
}
