package com.mirea.kt.practica2_10;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private final SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean savePhoneToDatabase(Phone phone) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("model", phone.getModel());
        cv.put("serial_number", phone.getSerial_number());
        cv.put("price", phone.getPrice());
        long rowId = db.insert("TABLE_PERSONS",null,cv);
        cv.clear();
        db.close();
        return rowId != 1;
    }
    public ArrayList<Phone> LoadAllPhoneFromDatabase(){
        ArrayList<Phone> phones = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_PHONES",null,null,null
                ,null,null,null);
        if(dbCursor.moveToFirst()){
            do{
                String Model = dbCursor.getString(dbCursor.getColumnIndexOrThrow("model"));
                String Snumber = dbCursor.getString(dbCursor.getColumnIndexOrThrow("serial_number"));
                int Price = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("price"));
                phones.add(new Phone(Model,Snumber, Price));
            }while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return phones;
    }
}
