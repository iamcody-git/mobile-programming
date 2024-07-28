package com.example.loogedin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class ListStudent extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.student_list,container,false);

        ListView studentListView = view.findViewById(R.id.studentListView);
        TextView textViewAvail = view.findViewById(R.id.notAvail);

     StudentDBHelper studentDBHelper = new StudentDBHelper(getContext());
        SQLiteDatabase db = studentDBHelper.getReadableDatabase();

        String[] columns = new String[]{"_id","username", "password"};
        Cursor cursor = db.query("students",columns,null,null,null,null,null);

 if(cursor.getCount() !=0){
     textViewAvail.setVisibility(view.INVISIBLE);
 }

    String[] from = new String[]{"username"};
    int[] to ={R.id.itemId};
       SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getContext(),R.layout.viewitem,cursor,from,to);
        studentListView.setAdapter(cursorAdapter);
     return view;
    }
}


