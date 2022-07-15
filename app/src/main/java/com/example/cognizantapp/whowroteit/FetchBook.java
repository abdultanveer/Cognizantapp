package com.example.cognizantapp.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

public class FetchBook extends AsyncTask<String,Void,String> {

    private TextView mTitleText;
    private TextView mAuthorText;


    @Override
    protected String doInBackground(String... strings) {
        //hitting the url and getting the json string
        return null;
    }
}
