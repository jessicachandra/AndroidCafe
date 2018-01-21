package com.example.jessicachandra.androidcafe;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Jessica Chandra on 16/01/2018.
 */

public class FetchMenuData extends AsyncTask<Void ,Void, String >{
    public AsyncResponse delegate = null;

    @Override
    protected String doInBackground(Void... params) {


        Log.v("aldo","20");
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String forecastJsonStr = null;


        Log.v("aldo","21");
        try {
            Log.v("aldo","31");
            URL url = null;
            try {
                Log.v("aldo","32");
                url = new
                        URL("http://560057.youcanlearnit.net/services/json/itemsfeed.php");
                Log.v("aldo","33");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Log.v("aldo","34");
            try {
                Log.v("aldo","35");
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.v("aldo","36");
            urlConnection.setRequestMethod("GET");
            Log.v("aldo","37");
            urlConnection.connect();
            Log.v("aldo","38");

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null){
                return null; }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while
                    ((line=reader.readLine()) != null){
                buffer.append(line +"\n");
            }
            if (buffer.length() == 0) {
                return null ;}

            forecastJsonStr = buffer.toString();
            return forecastJsonStr;
        } catch (Exception e) {
           Log.v("PlaceholderFragment","Error",e);
           return null;
        }
        finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
    }
    @Override
    protected void onPostExecute(String s) {


        Log.v("aldo","22");
        super.onPostExecute(s);
    }
}