package com.example.cognizantapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

//String -- input type, Integer = progress type, Bitmap = result type
public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar mProgressBar;
    public DownloadTask(ProgressBar progressBar) {
        mProgressBar = progressBar;
    }

    @Override //this method will execute on a background thread
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG, "downloading--"+strings[0]);
        publishProgress(50);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressBar.setProgress(values[0]);
    }
}
