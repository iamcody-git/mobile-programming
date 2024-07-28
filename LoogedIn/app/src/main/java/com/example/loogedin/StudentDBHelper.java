package com.example.loogedin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "students";
    private static final int DB_VERSION =4;


    public StudentDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE students (_id INTEGER primary KEY AUTOINCREMENT, username varchar(255), password varchar(255))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE if exists students");
        onCreate(db);


    }
}
