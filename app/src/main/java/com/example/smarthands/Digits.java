package com.example.smarthands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Digits extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);

        recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        listItems.add(new Listitem("One"));
        listItems.add(new Listitem("Two"));
        listItems.add(new Listitem("Three"));
        listItems.add(new Listitem("Four"));
        listItems.add(new Listitem("Five"));
        listItems.add(new Listitem("Six"));
        listItems.add(new Listitem("Seven"));
        listItems.add(new Listitem("Eight"));
        listItems.add(new Listitem("Nine"));
        listItems.add(new Listitem("Ten"));

        adapter = new imageAdapter(listItems,this);
        recyclerView.setAdapter(adapter);
    }
}
