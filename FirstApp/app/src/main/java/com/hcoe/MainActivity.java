package com.hcoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;

    private  Button falseButton;

    private  Button nextButton;


    private int current_index =0;

    private Question[] questions = new Question[]{
            new Question(R.string.question,true),
            new Question(R.string.question_1,true),
            new Question(R.string.question_2,true),
            new Question(R.string.question_3,false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView questionTextView = findViewById(R.id.question_text);
        questionTextView.setText(this.questions[this.current_index].getQuestionId());

        trueButton = findViewById(R.id.correct);
        falseButton = findViewById(R.id.incorrect);
        nextButton = findViewById(R.id.next);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions[current_index].isAnswer() == true) {
                    Toast.makeText(MainActivity.this, R.string.correctanswer, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrectanswer, Toast.LENGTH_SHORT).show();
                }


            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions[current_index].isAnswer()==false) {
                    Toast.makeText(MainActivity.this, R.string.correctanswer, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, R.string.incorrectanswer, Toast.LENGTH_SHORT).show();
                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(current_index >= questions.length-1 ) {
                    current_index =0;
                }else{
                    current_index ++;
                }
                questionTextView.setText(questions[current_index].getQuestionId());

            }
        });

        }

}