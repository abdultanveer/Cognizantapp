package com.example.cognizantapp.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

public class FetchBook extends AsyncTask<String,Void,String> {

    private TextView mTitleText;
    private TextView mAuthorText;


    public FetchBook(TextView mTitleText, TextView mAuthorText) {
        this.mTitleText = mTitleText;
        this.mAuthorText = mAuthorText;
    }



    @Override
    protected String doInBackground(String... url) {
        //hitting the url and getting the json string
        return NetworkUtils.getBookInfo(url[0]);
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        //parse the json string and extract the name of author
    }
}
