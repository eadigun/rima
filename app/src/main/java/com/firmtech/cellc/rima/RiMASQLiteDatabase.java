package com.firmtech.cellc.rima;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emmanuel Adigun on 2016/09/14.
 */
public class RiMASQLiteDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RiMA.db";
    public static final int DATABASE_VERSION = 1;

    Context RiMAContext;

    public RiMASQLiteDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        RiMAContext = context;
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Resources.getSystem().getString(R.string.sql_create_table_log_types));
        db.execSQL(Resources.getSystem().getString(R.string.sql_create_table_logs));
    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}

}
