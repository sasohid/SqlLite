package com.sa_software.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class data extends SQLiteOpenHelper {


    public static  final String name="myname";
    public static final int version= 1;

    public data(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE mytable (contact_id INTERGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULl," +
                "phone TEXT NOT NULL UNIQUE)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("drop table if exists mytable");
        onCreate(db);

    }

    public void input(String name,String phone){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name","name");
        contentValues.put("phone","phone");
        sqLiteDatabase.insert("mytable",null,contentValues);
    }



}
