package com.example.smarthands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class  Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    private int images[] =
            {
                    R.drawable.text,R.drawable.recorder,R.drawable.dict,R.drawable.history,
                    R.drawable.interpreter,R.drawable.camera
            };

    private String names[] =
            {
                    "Interpreter","Recorder","Dictionary","History","Nearby Interpreter","camera"
            };

    private int color[] =
            {
                    R.color.blue12,R.color.Red,R.color.DarkGreen,R.color.Green,R.color.grey,R.color.pink
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(Home.this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(Home.this,images,names,color);
        recyclerView.setAdapter(myAdapter);
    }
}
