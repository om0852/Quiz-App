package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button easyBtn,medBtn,hardBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyBtn = findViewById(R.id.easyBtn);
        medBtn = findViewById(R.id.midBtn);
        hardBtn = findViewById(R.id.hardBtn);
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t1 = new Intent(MainActivity.this, quiz_page.class);
                t1.putExtra("mode",10);
                startActivity(t1);
            }
        });medBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t1 = new Intent(MainActivity.this, quiz_page.class);
                t1.putExtra("mode",15);
                startActivity(t1);
            }
        });hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t1 = new Intent(MainActivity.this, quiz_page.class);
                t1.putExtra("mode",20);
                startActivity(t1);
            }
        });
    }
}