package com.example.openpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signInActivity(View v) {
        Toast.makeText(getApplicationContext(), "Sign In Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, sing_in.class);
        startActivity(intent);
    }
}