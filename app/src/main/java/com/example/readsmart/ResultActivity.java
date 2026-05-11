package com.example.readsmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtScore, txtFeedback, txtHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtScore = findViewById(R.id.txtScore);
        txtFeedback = findViewById(R.id.txtFeedback);
        txtHistory = findViewById(R.id.txtHistory);

        SharedPreferences prefs = getSharedPreferences("ReadSmartHistory", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int score = getIntent().getIntExtra("score", -1);
        String feedback = getIntent().getStringExtra("feedback");

        // CURRENT RESULT MODE
        if (score != -1 && feedback != null) {

            txtScore.setText("Latest Score: " + score + " / 3");
            txtFeedback.setText("Feedback: " + feedback);

            // SAVE HISTORY ONLY WHEN REAL RESULT EXISTS
            String oldHistory = prefs.getString("history", "");
            String newEntry = "Score: " + score + "/3 | " + feedback + "\n";

            editor.putString("history", oldHistory + newEntry);
            editor.apply();

        } else {
            txtScore.setText("View Results");
            txtFeedback.setText("");
        }

        // LOAD HISTORY
        String history = prefs.getString("history", "");

        if (history.trim().isEmpty()) {
            txtHistory.setText("No results yet.");
        } else {
            txtHistory.setText(history);
        }
    }

    public void goHome(View view) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}