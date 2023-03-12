package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signactivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Signuplol;
    private EditText emaillol,passwordlol,namelol;
    private Button submitlol;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signactivity);
        Signuplol = findViewById(R.id.Signuplol);
        emaillol = findViewById(R.id.emailol);
        passwordlol = findViewById(R.id.passwordlol);
        namelol = findViewById(R.id.namelol);
        submitlol = findViewById(R.id.submitlol);
        submitlol.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


    }

    @Override
    public void onClick(View view) {
        if(view == submitlol){
            create_user(emaillol.getText().toString(),passwordlol.getText().toString());

        }
    }
    public void create_user(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            String user = String.valueOf(new User(namelol.getText().toString(),emaillol.getText().toString(),passwordlol.getText().toString()));
                            String uid = mAuth.getCurrentUser().getUid().toString();
                            database.getReference("user").child(uid).setValue(user);
                           Intent i = new Intent(signactivity.this, Home.class);
                           startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(signactivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}