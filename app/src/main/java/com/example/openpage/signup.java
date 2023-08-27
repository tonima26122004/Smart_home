package com.example.openpage;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    EditText email,pass;
    Button buttonReg;
    FirebaseAuth mAuth;
    public static final String EXTRA_NAME = "com.example.openpage.extra.NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth= FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password1);
        buttonReg = findViewById(R.id.signup);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameText = email.getText().toString();

                String namePass = pass.getText().toString();

                mAuth.createUserWithEmailAndPassword(nameText, namePass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }

















    public void testerActivity(View v) {
        Intent intent = new Intent(this, tester.class);
        email = findViewById(R.id.email);
        String nameText = email.getText().toString();
        pass = findViewById(R.id.password1);
        String namePass = pass.getText().toString();
        intent.putExtra(EXTRA_NAME, namePass);
        Toast.makeText(getApplicationContext(), namePass, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}