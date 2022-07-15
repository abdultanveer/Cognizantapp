package com.example.cognizantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBar);
    }

    public void downloadHandler(View view) {
        DownloadTask dTask = new DownloadTask(progressBar);
        dTask.execute("https://www.imageurl.com");
    }

    public void invokeHandler(View view) {
        Intent rIntent = new Intent("tomcruise.isin.your.BUILDING");
        startActivity(rIntent);
    }
}