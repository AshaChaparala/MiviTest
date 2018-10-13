package com.mivi.mivitest;

import android.app.Application;

import com.google.gson.Gson;
import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.data.SharedPrefsHelper;
import com.mivi.mivitest.model.Sample;

import java.io.IOException;
import java.io.InputStream;

public class MainApp extends Application {

    DataManager dataManager;
    Sample data=null;
    String json = null;
    @Override
    public void onCreate() {
        super.onCreate();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);
        readLocalJson();

    }

    public Sample readLocalJson() {
        if(data==null) {

            try {
                InputStream is = getAssets().open("collection.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
                data = new Gson().fromJson(json, Sample.class);
                return data;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            return data;
        }
        return null;
    }

    public String getLocalJsonString() {
        if(json==null) {

            try {
                InputStream is = getAssets().open("collection.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
                data = new Gson().fromJson(json, Sample.class);
                return json;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            return json;
        }
        return null;
    }
    public DataManager getDataManager() {
        return dataManager;
    }

}
