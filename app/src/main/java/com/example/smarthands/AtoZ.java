package com.example.smarthands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AtoZ extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ato_z);

        recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        for(int i=1;i<27;i++){
            char ch = (char) (i+64);
            String hd = Character.toString(ch);
            Log.d("Character",hd);
            Listitem listItem = new Listitem(
                    hd
            );
            listItems.add(listItem);
        }

        adapter = new imageAdapter(listItems,this);
        recyclerView.setAdapter(adapter);

    }
}
