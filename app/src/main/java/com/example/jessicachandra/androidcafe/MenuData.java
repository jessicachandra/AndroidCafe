package com.example.jessicachandra.androidcafe;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Jessica Chandra on 16/01/2018.
 */

public class MenuData {
    private static String jsondata = "";

    public void setJsonData(String json){
        jsondata = json;
        Log.i("DATA",jsondata);

    }
    public static ArrayList<Menu> getListMenu() {


        Log.v("aldo","10");
        String response = null;
        Menu menu = null;


        Log.v("aldo","11");
        FetchMenuData conn = (FetchMenuData) new FetchMenuData();
        conn.execute();
        try {
            jsondata = conn.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Log.v("aldo","12");
        ArrayList<Menu> list = new ArrayList<>();


        Log.v("aldo","18");
        try {


            Log.v("aldo","19");
            JSONArray jsonArray = new JSONArray(jsondata);


            Log.v("aldo","14");
            Gson gson = new Gson();
            int i = 0;


            Log.v("aldo","15");
            while (i < jsonArray.length()) {
                list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Menu.class));
                i++;
            }
        } catch (JSONException e) {


            Log.v("aldo","16");
            e.printStackTrace();


            Log.v("aldo","17");
        }


        Log.v("aldo","13");
        return list;
    }
    }