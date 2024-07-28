package com.example.loogedin;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class StudentFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container,false);

        EditText studentNameView = view.findViewById(R.id.nameId);
        EditText studentPwdView = view.findViewById(R.id.addressId);
        Button studentSubmitButton = view.findViewById(R.id.addId);

        studentSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName = studentNameView.getText().toString();
                String studentPassword = studentPwdView.getText().toString();

                StudentDBHelper studentDBHelper = new StudentDBHelper(getContext());
                SQLiteDatabase db =  studentDBHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("username", studentName);
                values.put("password",studentPassword);

                db.insert("students", null, values);
                Snackbar.make(view,"students created sucessfully", Snackbar.LENGTH_SHORT).show();


            }
        });

        return view;
    }
}
