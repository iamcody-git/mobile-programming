package hcoe.com;

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

public class MainActivity extends AppCompatActivity {

     private Button trueButton;
     private Button falseButton;
     private Button prevButton;
     private Button nextButton;
     private int currect_index=0;

     private QuizQuestion[] quiz = new QuizQuestion[]{
             new QuizQuestion(R.string.question_1,true),
             new QuizQuestion(R.string.question_2,false),

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

        TextView questionTextView = findViewById(R.id.question_1);
        questionTextView.setText(this.quiz[this.currect_index].getQuestionId());


        trueButton = findViewById(R.id.correct);
        falseButton = findViewById(R.id.incorrect);
        prevButton = findViewById(R.id.prev);
        nextButton = findViewById(R.id.next);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quiz[currect_index].isAnswer()==true){
                    Toast.makeText(MainActivity.this,R.string.correctAns,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,R.string.incorrectAns,Toast.LENGTH_SHORT).show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quiz[currect_index].isAnswer()==false){
                    Toast.makeText(MainActivity.this,R.string.correctAns,Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this,R.string.incorrectAns,Toast.LENGTH_SHORT).show();

                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currect_index <= 0){
                    currect_index =quiz.length -1;
                }else{
                    currect_index --;
                }
                questionTextView.setText(quiz[currect_index].getQuestionId());


            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currect_index >= quiz.length -1){
                    currect_index =0;
                }
                else {
                    currect_index ++;
                }

                questionTextView.setText(quiz[currect_index].getQuestionId());

            }
        });

        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currect_index >= quiz.length -1){
                    currect_index = 0;
                }
                else{
                    currect_index ++;
                }

                questionTextView.setText(quiz[currect_index].getQuestionId());
            }
        });
    }
}