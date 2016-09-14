package com.firmtech.cellc.rima;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Emmanuel Adigun on 2016/09/14.
 */
public class RiMASQLiteDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RiMA.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TAG = "RiMASQLiteDatabase";

    Context RiMAContext;

    public RiMASQLiteDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        RiMAContext = context;
    }
    public void onCreate(SQLiteDatabase db) {
        //DB Setup etc ...
        db.execSQL(RiMAContext.getResources().getString(R.string.sql_create_table_log_types));
        db.execSQL(RiMAContext.getResources().getString(R.string.sql_create_table_logs));
        db.execSQL(RiMAContext.getResources().getString(R.string.sql_create_table_settings));



    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}

    public String fetchSettingValue(String key)
    {
        String value = "";
        SQLiteDatabase db = getReadableDatabase();
        String sql = RiMAContext.getResources().getString(R.string.sql_raw_query_fetch_settings);
        Cursor cur = db.rawQuery(sql, new String[] { key });

        if (cur.moveToNext()) {
            value =  cur.getString(0);
        }

        cur.close();
        db.close();

        return value;
    }

    public void updateSettingValue(String key, String value)
    {
        ContentValues row = new ContentValues();
        row.put("rs_key", key);
        row.put("rs_value", value);

        SQLiteDatabase db = null;

        if ( fetchSettingValue(key) == "" )
        {
            db = getWritableDatabase();
            db.insert("rs_rima_settings", null, row);
        }
        else
        {
            db = getWritableDatabase();
            db.update("rs_rima_settings", row, "rs_key = ?", new String[] { value } );
        }

        db.close();
    }

    public Cursor fetchAllRows(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        if (db == null) {
            return null;
        }
        return db.rawQuery(sql, null);
    }

}
