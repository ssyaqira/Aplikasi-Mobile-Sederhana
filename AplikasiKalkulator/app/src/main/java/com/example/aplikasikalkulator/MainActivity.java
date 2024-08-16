package com.example.aplikasikalkulator;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {
    protected float angka1, angka2, angkahasil;
    EditText tek_1, tek_2, tek_hasil;
    private ArrayList<String> isi_histori = new ArrayList<String>();
    ListView histori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tek_1 = (EditText) findViewById(R.id.angka_1);
        tek_2 = (EditText) findViewById(R.id.angka_2);
        tek_hasil = (EditText) findViewById(R.id.text_hasil);
        histori = (ListView) findViewById(R.id.list_histori);
        Button tambah = (Button) findViewById(R.id.tombol_plus);
        Button kurang = (Button) findViewById(R.id.tombol_min);
        Button kali = (Button) findViewById(R.id.tombol_x);
        Button bagi = (Button) findViewById(R.id.tombol_bagi);
        tambah.setOnClickListener(this);
        kurang.setOnClickListener(this);
        kali.setOnClickListener(this);
        bagi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        angka1 = Float.parseFloat(tek_1.getText().toString());
        angka2 = Float.parseFloat(tek_2.getText().toString());

        switch (v.getId()) {
            case R.id.tombol_plus:
                angkahasil = angka1 + angka2;
                tek_hasil.setText(Float.toString(angkahasil));
                this.tampilkan_histori(angka1 + " + " + angka2 + " = " + angkahasil);
                break;
            case R.id.tombol_min:
                angkahasil = angka1 - angka2;
                tek_hasil.setText(Float.toString(angkahasil));
                this.tampilkan_histori(angka1 + " - " + angka2 + " = " + angkahasil);
                break;
            case R.id.tombol_x:
                angkahasil = angka1 * angka2;
                tek_hasil.setText(Float.toString(angkahasil));
                this.tampilkan_histori(angka1 + " x " + angka2 + " = " + angkahasil);
                break;
            case R.id.tombol_bagi:
                if (angka2 != 0) {
                    angkahasil = angka1 / angka2;
                    tek_hasil.setText(Float.toString(angkahasil));
                    this.tampilkan_histori(angka1 + " : " + angka2 + " = " + angkahasil);
                } else {
                    tek_hasil.setText("Error: Division by Zero");
                    this.tampilkan_histori("Error: " + angka1 + " : " + angka2 + " = Undefined");
                }
                break;
            default:
                break;
        }
    }

    private void tampilkan_histori(String tambahan) {
        isi_histori.add(tambahan);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, isi_histori);
        histori.setAdapter(adapter);
    }
}
