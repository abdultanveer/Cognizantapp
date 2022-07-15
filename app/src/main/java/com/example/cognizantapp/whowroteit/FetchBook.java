package com.example.cognizantapp.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for(int i = 0; i<itemsArray.length(); i++){
                    JSONObject book = itemsArray.getJSONObject(i); //Get the current item
                    String title=null;
                    String authors=null;
                    JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");

                    if (title != null && authors != null){
                        mTitleText.setText(title);
                        mAuthorText.setText(authors);
                        return;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
