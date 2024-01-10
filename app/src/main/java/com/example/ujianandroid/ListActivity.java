package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getStringArrayListExtra("daftar_nama");
        ArrayList<Integer> daftar_umur = getIntent().getIntegerArrayListExtra("daftar_umur");

        if (daftar_nama == null || daftar_nama.isEmpty() || daftar_umur == null || daftar_umur.isEmpty()) {
            daftar_nama = new ArrayList<>();
            daftar_nama.add("Data masih kosong");
            daftar_umur = new ArrayList<>();
            daftar_umur.add(0); // Add a placeholder age
        }

        ArrayList<String> daftar_status = new ArrayList<>();

        for (int umur : daftar_umur) {
            String status;
            if (umur < 10) {
                status = "Anak";
            } else if (umur < 20) {
                status = "Remaja";
            } else if (umur < 40) {
                status = "Dewasa";
            } else {
                status = "Tua";
            }
            daftar_status.add(status);
        }

        ArrayAdapter<String> ad_status = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_status);

        lvNama.setAdapter(ad_status);
    }
}

