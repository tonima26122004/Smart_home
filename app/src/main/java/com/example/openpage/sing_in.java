package com.example.openpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sing_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
    }

    public void signUpActivity(View v) {
        Toast.makeText(getApplicationContext(), "Sign up Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}