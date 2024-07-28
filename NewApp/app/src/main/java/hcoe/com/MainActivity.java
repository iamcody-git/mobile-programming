package hcoe.com;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button prevButton;
    private Button nextButton;
    private Button cheatButton;
    private boolean isCheater = false;
    private int current_index = 0;
    private boolean[] cheatedQuestions;

    private QuizQuestion[] quiz = new QuizQuestion[]{
            new QuizQuestion(R.string.quiz_1, true),
            new QuizQuestion(R.string.quiz_2, true),
            new QuizQuestion(R.string.quiz_3, false)
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mainactivity", "onStart method is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mainactivity", "onResume method is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mainactivity", "onDestory method is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mainactivity", "onStop method is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mainactivity", "onPause method is called");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("mainactivity", "onSaveInstance called");
        outState.putInt("current_index", current_index);
        outState.putBoolean("isCheater", isCheater);
        outState.putBooleanArray("cheatedQuestions", cheatedQuestions);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        current_index = savedInstanceState.getInt("current_index");
//        isCheater = savedInstanceState.getBoolean("isCheater");
//        cheatedQuestions = savedInstanceState.getBooleanArray("cheatedQuestions");
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 0) {
                if (data != null) {
                    isCheater = data.getBooleanExtra("answer_shown", false);
                    if (isCheater) {
                        cheatedQuestions[current_index] = true;
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        if (savedInstanceState != null) {
            current_index = savedInstanceState.getInt("current_index", 0);
            isCheater = savedInstanceState.getBoolean("isCheater", false);
            cheatedQuestions = savedInstanceState.getBooleanArray("cheatedQuestions");
        } else {
            cheatedQuestions = new boolean[quiz.length];
        }

        Log.d("mainactivity", "onCreate method is called");

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView handleTextView = findViewById(R.id.quiz);
        handleTextView.setText(this.quiz[this.current_index].getQuestionId());

        trueButton = findViewById(R.id.correct);
        falseButton = findViewById(R.id.incorrect);
        nextButton = findViewById(R.id.next);
        prevButton = findViewById(R.id.prev);
        cheatButton = findViewById(R.id.cheat_btn);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cheatedQuestions[current_index]) {
                    Toast.makeText(MainActivity.this, "you are a cheater", Toast.LENGTH_SHORT).show();
                } else if (quiz[current_index].isAnswer() == true) {
                    Toast.makeText(MainActivity.this, R.string.correctAns, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrectAns, Toast.LENGTH_SHORT).show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cheatedQuestions[current_index]) {
                    Toast.makeText(MainActivity.this, "you are a cheater", Toast.LENGTH_SHORT).show();
                } else if (quiz[current_index].isAnswer() == false) {
                    Toast.makeText(MainActivity.this, R.string.correctAns, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrectAns, Toast.LENGTH_SHORT).show();
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current_index <= 0) {
                    current_index = quiz.length - 1;
                } else {
                    current_index--;
                }
                handleTextView.setText(quiz[current_index].getQuestionId());
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current_index >= quiz.length - 1) {
                    current_index = 0;
                } else {
                    current_index++;
                }
                handleTextView.setText(quiz[current_index].getQuestionId());
            }
        });

        handleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current_index >= quiz.length - 1) {
                    current_index = 0;
                } else {
                    current_index++;
                }
                handleTextView.setText(quiz[current_index].getQuestionId());
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CheatActivity.class);
                i.putExtra("answer", quiz[current_index].isAnswer());
                //startActivity(i);
                startActivityForResult(i, 0);
            }
        });
    }
}
