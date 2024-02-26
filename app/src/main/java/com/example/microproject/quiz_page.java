package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class quiz_page extends AppCompatActivity {
    Button option1,option2,option3,option4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
         option1 =findViewById(R.id.option1);
         option2 =findViewById(R.id.option2);
         option3 =findViewById(R.id.option3);
         option4 =findViewById(R.id.option4);
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
         });option4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 option_fun4();
             }
         });

    }

    public void option_fun1() {
        option1.setBackgroundColor(Color.GREEN);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.RED);
    }
    public void option_fun2() {
        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.GREEN);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.RED);    }
    public void option_fun3() {
        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.GREEN);
        option4.setBackgroundColor(Color.RED);
    }
    public void option_fun4() {
        option1.setBackgroundColor(Color.RED);
        option2.setBackgroundColor(Color.RED);
        option3.setBackgroundColor(Color.RED);
        option4.setBackgroundColor(Color.GREEN);    }
}