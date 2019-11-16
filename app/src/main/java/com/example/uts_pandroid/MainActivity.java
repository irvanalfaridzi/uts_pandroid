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

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static String dbname="stok.db";
    EditText kode, nama, satuan, hbeli, hjual, diskon;
    Button simpan, update, delete, clear;
    ListView isilist;
    SQLiteDatabase db;
    String kd, nm, st, hb, hj, dsk;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select * from barang", null);
        final String kode11[] = new String[c.getCount()];
        String nama11[] = new String[c.getCount()];
        String satuan11[] = new String[c.getCount()];
        String hbeli11[] = new String[c.getCount()];
        String hjual11[] = new String[c.getCount()];
        String diskon11[] = new String[c.getCount()];
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

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);
            db.execSQL("CREATE table if not exists barang(kode varchar(20), nama varchar(20), satuan varchar(100),hbeli varchar(100), hjual varchar(100), diskon varchar(100));");

            kd = kode.getText().toString();
            nm = nama.getText().toString();
            st = satuan.getText().toString();
            hb = hbeli.getText().toString();
            hj = hjual.getText().toString();
            dsk = diskon.getText().toString();

            db.execSQL("insert into barang values('"+ kd+"','"+ nm +"','"+ st +"','"+ hb +"','"+ hj +"','"+ dsk +"');");
            Cursor c = db.rawQuery("select * from barang", null);
                String kode11[] = new String[c.getCount()];
                String nama11[] = new String[c.getCount()];
                String satuan11[] = new String[c.getCount()];
                String hbeli11[] = new String[c.getCount()];
                String hjual11[] = new String[c.getCount()];
                String diskon11[] = new String[c.getCount()];
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
                String kode11[] = new String[c.getCount()];
                String nama11[] = new String[c.getCount()];
                String satuan11[] = new String[c.getCount()];
                String hbeli11[] = new String[c.getCount()];
                String hjual11[] = new String[c.getCount()];
                String diskon11[] = new String[c.getCount()];
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
                String kode11[] = new String[c.getCount()];
                String nama11[] = new String[c.getCount()];
                String satuan11[] = new String[c.getCount()];
                String hbeli11[] = new String[c.getCount()];
                String hjual11[] = new String[c.getCount()];
                String diskon11[] = new String[c.getCount()];
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
//                db=openOrCreateDatabase(dbname,MODE_PRIVATE,null);
//                HashMap<String, Object> obj = (HashMap<String, Object>)adapterView.getItemAtPosition(i);
//                String kodeget = (String) obj.get("kode");
//                kode.setText(kodeget);
//                Cursor c = db.rawQuery("select * from barang where kode = '"+ kd +"';", null);
//                nm = c.getString(c.getColumnIndex("nama"));
//                st = c.getString(c.getColumnIndex("satuan"));
//                hb = c.getString(c.getColumnIndex("hbeli"));
//                hj = c.getString(c.getColumnIndex("hjual"));
//                dsk = c.getString(c.getColumnIndex("diskon"));
//                kode.setText(kd);
//                nama.setText(st);
//                hbeli.setText(hb);
//                hjual.setText(hj);
//                diskon.setText(dsk);
                update.setEnabled(true);
                delete.setEnabled(true);
            }
        });

    }
}
