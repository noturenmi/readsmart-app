package com.example.readsmart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnResults, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("READSMART");
        }

        btnStart = findViewById(R.id.btnStart);
        btnResults = findViewById(R.id.btnResults);
        btnExit = findViewById(R.id.btnExit);

        // Start Reading → go to InputActivity
        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InputActivity.class);
            startActivity(intent);
        });

        // View Results → go to ResultActivity
        btnResults.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            startActivity(intent);
        });

        // Exit App
        btnExit.setOnClickListener(v -> finish());
    }
}