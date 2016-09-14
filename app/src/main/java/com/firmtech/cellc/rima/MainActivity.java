package com.firmtech.cellc.rima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Emmanuel Adigun on 2016/09/14.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RiMASQLiteDatabase rimaDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Initializing SQLite Database ...");
        rimaDB = new RiMASQLiteDatabase(getApplicationContext());

        setContentView(R.layout.activity_main);

        //String url = rimaDB.fetchSettingValue("RIMA_URL");
        //Log.d(TAG, "Server URL : " + url);
    }
}
