package com.example.openpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText email,pass;
    Button buttonReg,buttonReg2;
    FirebaseAuth mAuth;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    public static final String EXTRA_NAME = "com.example.openpage.extra.NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth= FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password1);
        buttonReg = findViewById(R.id.signup);
        buttonReg2 = findViewById(R.id.gbtn);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        buttonReg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
    });
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

void signIn(){
        Intent signinIntent = gsc.getSignInIntent();
        startActivityForResult(signinIntent,1000);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(this, tester.class);
        startActivity(intent);
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