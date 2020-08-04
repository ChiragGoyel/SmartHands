package com.example.smarthands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Colors extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        listItems.add(new Listitem("Black"));
        listItems.add(new Listitem("Blue"));
        listItems.add(new Listitem("Green"));
        listItems.add(new Listitem("Indigo"));
        listItems.add(new Listitem("Orange"));
        listItems.add(new Listitem("Pink"));
        listItems.add(new Listitem("Red"));
        listItems.add(new Listitem("Violet"));
        listItems.add(new Listitem("White"));
        listItems.add(new Listitem("Yellow"));

        adapter = new imageAdapter(listItems,this);
        recyclerView.setAdapter(adapter);
    }
}
