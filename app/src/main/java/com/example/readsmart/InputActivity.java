package com.example.readsmart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    EditText editTextInput;
    Button btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextInput = findViewById(R.id.editTextInput);
        btnGenerate = findViewById(R.id.btnGenerate);

        btnGenerate.setOnClickListener(v -> {
            String text = editTextInput.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(InputActivity.this, "Please enter text first", Toast.LENGTH_SHORT).show();
            } else {
                // Go to QuestionActivity
                Intent intent = new Intent(InputActivity.this, QuestionActivity.class);
                intent.putExtra("inputText", text);
                startActivity(intent);
            }
        });
    }
}