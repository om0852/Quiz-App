package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz_page extends AppCompatActivity {
    Button option1,option2,option3,option4,submit;
    TextView questions,question;
    int score=0,totalQuestion=QuestionAnswer.question.length;
    int currentQuestionIndex=0;
    String selectedAns="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
         option1 =findViewById(R.id.option1);
         option2 =findViewById(R.id.option2);
         option3 =findViewById(R.id.option3);
         option4 =findViewById(R.id.option4);
         questions= findViewById(R.id.totalquestion);
         question= findViewById(R.id.question);
         submit =findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
                 if(QuestionAnswer.question.length>(currentQuestionIndex+1)){

                 if(QuestionAnswer.correctAnswer[currentQuestionIndex]==selectedAns){
                     score++;
                 }
                 currentQuestionIndex++;
                     if(QuestionAnswer.question.length<(currentQuestionIndex+2)) {
                         submit.setText("Submit");
                     }

                     loadNewQuestion();
             }
                 else{
                     //result is show
                 }
                 }

         });
loadNewQuestion();
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
}