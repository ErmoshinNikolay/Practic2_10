package com.mirea.kt.practica2_10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyAppSQLiteHelper  extends SQLiteOpenHelper {
    public MyAppSQLiteHelper(Context c, String name,
                             SQLiteDatabase.CursorFactory f, int version) {
        super(c, name, f, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "TABLE_PHONES" + " ("
                + "_id integer primary key autoincrement,"
                + "model text,"
                + "serial_number text,"
                + "price integer" + ");");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // если версия изменилаcь, то вносим нужные нам изменения
    }

}