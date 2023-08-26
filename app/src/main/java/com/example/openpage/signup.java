package com.example.openpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void openActivity2(View v) {
        Toast.makeText(getApplicationContext(), "Sign up Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, sing_in.class);
        startActivity(intent);
    }
}