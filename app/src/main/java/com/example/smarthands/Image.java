package com.example.smarthands;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.VideoView;

public class Image extends AppCompatActivity {

    private TextView mtextview;
    private VideoView videoView;
    private MediaController mediaController = null;
    int rawId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        mtextview = (TextView) findViewById(R.id.text);

        Bundle b = getIntent().getExtras();
        String head = b.getString("header");

        mtextview.setText(head);
        rawId = getResources().getIdentifier(head.toLowerCase(), "raw", getPackageName());

        String path = "android.resource://" + getPackageName() + "/" + rawId;

        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        mediaController.hide();

    }
}
