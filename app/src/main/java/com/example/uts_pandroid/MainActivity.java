package com.example.uts_pandroid;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

//    inisialisasi setting variabel
    static String dbname="stok.db";
    EditText kode, nama, satuan, hbeli, hjual, diskon;
    TextView hasilh;
    Button simpan, update, delete, clear;
    ListView isilist;
    SQLiteDatabase db;
    String kd, nm, st, hb, hj, dsk;
    int x;
    String kode1[];
    String nama1[];
    String satuan1[];
    Integer hjual1[];
    Integer hbeli1[];
    Integer diskon1[];
    String alamaturl = "http://192.168.43.89/android/apiAndroid/index.php";


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
        hasilh = (TextView)findViewById(R.id.tvHasil);

        simpan = (Button)findViewById(R.id.btnSimpan);
        update = (Button)findViewById(R.id.btnUpdate);
        delete = (Button)findViewById(R.id.btnHapus);
        clear = (Button)findViewById(R.id.btnClear);

//        memunculkan data
        final JsonObjectRequest jsantrian;
        jsantrian = new JsonObjectRequest(Request.Method.POST, alamaturl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String x = response.toString();
                        Log.d("response", x);
                        try {
                            JSONObject obj = new JSONObject(x);
                            JSONArray hasil = obj.getJSONArray("rowData");
                            int jmlData = hasil.length();
                            String tampil;
                            tampil = "";
                            kode1 = new String[jmlData];
                            nama1 = new String[jmlData];
                            satuan1 = new String[jmlData];
                            hbeli1 = new Integer[jmlData];
                            hjual1 = new Integer[jmlData];
                            diskon1 = new Integer[jmlData];
                            for (int i = 0; i < jmlData; i++) {
                                JSONObject kumpulandata = hasil.getJSONObject(i);
                                kode1[i] = kumpulandata.getString("kode_barang");
                                nama1[i] = kumpulandata.getString("nama_barang");
                                satuan1[i] = kumpulandata.getString("satuan");
                                hbeli1[i] = kumpulandata.getInt("hbeli");
                                hjual1[i] = kumpulandata.getInt("hjual");
                                diskon1[i] = kumpulandata.getInt("diskon");
                                tampil =
                                        tampil + "\n" + kode1 + " " + nama1 + " " + satuan1 + " " + hbeli1 + " " + hjual1 +
                                                " " + diskon1;
                            }
                            Ngisine adapter =new Ngisine(getApplication(), kode1, nama1, satuan1, hbeli1, hjual1, diskon1);
                            isilist.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "bro "+error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("response", ""+error.getMessage());
                    }
                });

        final RequestQueue antrian = Volley.newRequestQueue(this);
        antrian.add(jsantrian);
//        akhir memunculkan data


        //    simpan data
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://192.168.43.89/android/apiAndroid/insert.php?";
                RequestQueue antri;

                antri = Volley.newRequestQueue(getApplicationContext());
                url = url + "kode_barang="+kode.getText().toString().trim()+"&nama_barang="+nama.getText().toString().trim()+
                        "&satuan="+satuan.getText().toString().trim()+"&hbeli="+hbeli.getText().toString().trim()+"&hjual="+hjual.getText().toString().trim()+
                        "&diskon="+diskon.getText().toString().trim();

                Toast.makeText(getApplicationContext(), url.toString(), Toast.LENGTH_SHORT).show();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();
                    }
                });
                antri.add(stringRequest);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://192.168.43.89/android/apiAndroid/update.php?";
                RequestQueue antri;

                antri = Volley.newRequestQueue(getApplicationContext());
                url = url + "kode_barang="+kode.getText().toString().trim()+"&nama_barang="+nama.getText().toString().trim()+
                        "&satuan="+satuan.getText().toString().trim()+"&hbeli="+hbeli.getText().toString().trim()+"&hjual="+hjual.getText().toString().trim()+
                        "&diskon="+diskon.getText().toString().trim();

                Toast.makeText(getApplicationContext(), url.toString(), Toast.LENGTH_SHORT).show();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();
                    }
                });
                antri.add(stringRequest);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://192.168.43.89/android/apiAndroid/delete.php?";
                RequestQueue antri;

                antri = Volley.newRequestQueue(getApplicationContext());
                url = url + "kode_barang="+kode.getText().toString().trim();

                Toast.makeText(getApplicationContext(), url.toString(), Toast.LENGTH_SHORT).show();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();
                    }
                });
                antri.add(stringRequest);
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
                Toast.makeText(MainActivity.this, kode1[i], Toast.LENGTH_SHORT).show();
                kode.setText(kode1[i]);
                nama.setText(nama1[i]);
                satuan.setText(satuan1[i]);
                hbeli.setText(String.valueOf(hbeli1[i]));
                hjual.setText(String.valueOf(hjual1[i]));
                diskon.setText(String.valueOf(diskon1[i]));
                update.setEnabled(true);
                delete.setEnabled(true);
            }
        });

    }
    }