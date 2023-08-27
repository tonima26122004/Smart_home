package com.example.openpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class tester extends AppCompatActivity {
    TextView testtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        testtxt = findViewById(R.id.testtxt);
        Intent intent = getIntent();
        String mail = intent.getStringExtra(signup.EXTRA_NAME);
        testtxt.setText("Your Name is "+ mail);
    }
}