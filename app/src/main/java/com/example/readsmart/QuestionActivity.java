package com.example.readsmart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    EditText ans1, ans2, ans3;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String a1 = ans1.getText().toString().trim();
            String a2 = ans2.getText().toString().trim();
            String a3 = ans3.getText().toString().trim();

            int score = 0;

            if (!a1.isEmpty()) score++;
            if (!a2.isEmpty()) score++;
            if (!a3.isEmpty()) score++;

            String feedback;
            if (score == 3) {
                feedback = "Excellent understanding!";
            } else if (score == 2) {
                feedback = "Good job, but can improve.";
            } else {
                feedback = "Try to answer more completely.";
            }

            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("feedback", feedback);
            startActivity(intent);
        });
    }
}