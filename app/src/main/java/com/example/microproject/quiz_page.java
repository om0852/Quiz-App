package com.example.microproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz_page extends AppCompatActivity {
    Button option1,option2,option3,option4,submit;
    TextView questions,question,title,timer;
    int totalAskQuestion=10;
    int score=0,totalQuestion=totalAskQuestion;
    int currentQuestionIndex=0;
    String selectedAns="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        int num = getIntent().getIntExtra("mode",10);
        totalAskQuestion=num;
        totalQuestion=num;
        title=findViewById(R.id.title);
        if(num==10){
            title.setText("Quiz Mode:- Easy");
        } else if (num==15) {
            title.setText("Quiz Mode:- Medium");

        }
        else{
            title.setText("Quiz Mode:- Hard");

        }
//        Toast.makeText(this, num, Toast.LENGTH_SHORT).show();
        MainLoader();
        TimerChecker();
    }
    public void MainLoader(){

        option1 =findViewById(R.id.option1);
        option2 =findViewById(R.id.option2);
        option3 =findViewById(R.id.option3);
        option4 =findViewById(R.id.option4);
        questions= findViewById(R.id.totalquestion);
        question= findViewById(R.id.question);
        submit =findViewById(R.id.submit);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_fun1();
            }
        });option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_fun2();
            }
        });option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_fun3();
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_fun4();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(totalAskQuestion>(currentQuestionIndex+1)){

                    if(QuestionAnswer.correctAnswer[currentQuestionIndex]==selectedAns){
                        score++;
                    }
                    currentQuestionIndex++;
                    if(totalAskQuestion<(currentQuestionIndex+2)) {
                        submit.setText("Submit");
                    }


                    loadNewQuestion();
                }
                else{
                    if(QuestionAnswer.correctAnswer[currentQuestionIndex]==selectedAns){
                        score++;
                    }
                    resultDeclare(score+" correct out of "+totalQuestion);
                }
            }

        });
        loadNewQuestion();

    }
    public void resultDeclare(String message){
        AlertDialog dialog = new AlertDialog.Builder(quiz_page.this)
                .setTitle("Result")
                .setMessage(message)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent t1 = new Intent(quiz_page.this,MainActivity.class);
                        startActivity(t1);
                    }
                }).create();
        dialog.show();

    }
    public void loadNewQuestion(){
        submit.setVisibility(View.INVISIBLE);
        questions.setText("Questions:("+(currentQuestionIndex+1)+"/"+totalQuestion+")");
        question.setText(QuestionAnswer.question[currentQuestionIndex]);
        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.RED);
        option1.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        option2.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        option3.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        option4.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }
    public void option_fun1() {
        submit.setVisibility(View.VISIBLE);
        selectedAns=option1.getText().toString();
        option1.setBackgroundColor(Color.GREEN);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.RED);
    }
    public void option_fun2() {
        submit.setVisibility(View.VISIBLE);

        selectedAns=option2.getText().toString();
        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.GREEN);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.RED);    }
    public void option_fun3() {
        submit.setVisibility(View.VISIBLE);

        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.GREEN);
        option4.setBackgroundColor(Color.RED);
        selectedAns=option3.getText().toString();

    }
    public void option_fun4() {
        submit.setVisibility(View.VISIBLE);

        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.GREEN);
        selectedAns=option4.getText().toString();

    }
    private Handler mHandler = new Handler();
    public void TimerChecker() {
        timer= findViewById(R.id.timer);
        t1.run();
    }

    public Runnable t1 = new Runnable() {
        final int[] i = {0}; // Declare i outside of run()

        @Override
        public void run() {
            Log.d("error", "welcome");
            try {
                i[0]++;
                timer.setText("(" + i[0] + "/60)");
                if (i[0] == 60) {
                    resultDeclare(score + " correct out of " + totalAskQuestion);
                    mHandler.removeCallbacks(t1);
                    return;
                }
                mHandler.postDelayed(this, 1000);
            } catch (Exception e) {
                Log.d("error", e.getMessage());
            }
        }
    };

}