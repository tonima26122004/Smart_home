package com.example.openpage;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openActivity(View v){
        Toast.makeText(getApplicationContext(),"Sign up Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this , signup.class);
        startActivity(intent);
    }

    public void openActivity2(View v){
        Toast.makeText(getApplicationContext(),"Sign up Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this , sing_in.class);
        startActivity(intent);
    }
}