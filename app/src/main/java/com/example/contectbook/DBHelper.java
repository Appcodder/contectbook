package com.example.contectbook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"mydata",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qurry = "create table mycontectbook(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, number TEXT)";
        db.execSQL(qurry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertmydata(String myname, String mynumber) {

        String qry = "insert into mycontectbook (name,number)values('" + myname + "','" + mynumber + "')";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(qry);

    }

    public Cursor Getmydata() {

        String qry = "select * from mycontectbook";

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(qry,null);
        return cursor;

    }
}
