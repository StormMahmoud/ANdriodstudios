package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    submit.setOnClickListener(this);
    @Override
    public void onClick(View view ){
        if (view == sumbit){
            welcome.settext("Goodbye")
        }
    }
}