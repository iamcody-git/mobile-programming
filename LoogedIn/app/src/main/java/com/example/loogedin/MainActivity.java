package com.example.loogedin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nameText;
    private TextInputEditText pwdText;
    private Button submitBtn;
    private Button addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameId);
        pwdText = findViewById(R.id.pwdId);
        submitBtn = findViewById(R.id.btnId);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String password = pwdText.getText().toString();
                String loginame = "cody";
                String loginpwd = "122";

                if ((loginpwd.equals(password)) && (loginame.equals(name))) {
                    Snackbar.make(findViewById(R.id.rootLayout), "You are logged in", Snackbar.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginPage.class);
                    startActivity(intent);
                } else {
                    Snackbar.make(findViewById(R.id.rootLayout), "Wrong username and password", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
