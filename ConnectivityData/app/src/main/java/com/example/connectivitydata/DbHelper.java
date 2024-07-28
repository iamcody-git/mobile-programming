package com.example.connectivitydata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME ="Teacher";
    public static  final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE teacher_attend(_id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, password VARCHAR)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS teacher_attend");
        onCreate(db);

    }

    public  void InsertData(String username, String passowrd){
        SQLiteDatabase db = this.getWritableDatabase();

        addValue values = new addValue();
        values.add(Name ,username);
        values.add(Passowrd, passowrd);

        db.insert(teacher_attend, null, values);


    }

}
