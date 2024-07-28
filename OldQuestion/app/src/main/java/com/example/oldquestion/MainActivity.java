package com.example.oldquestion;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private TextView nameFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView lview = findViewById(R.id.lv);
        String[] names = {"Cody", "Milan" ,"Sahil", "John", "Sujal"};
        ArrayAdapter<String> nameAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names);
        lview.setAdapter(nameAdapter);

        nameFirst = findViewById(R.id.textDetail);

      //  String nameFirst = names[0];



        nameFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Developer", Toast.LENGTH_SHORT).show();
            }
        });



    }
}