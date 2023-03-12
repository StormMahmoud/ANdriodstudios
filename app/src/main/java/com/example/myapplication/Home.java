package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private TextView Welcome;
    private ListView listView;
    private ArrayList<User> users;
    private ArrayAdapter<User> arrayAdapter;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Welcome = findViewById(R.id.Welcome);
        mAuth = FirebaseAuth.getInstance();
        listView = findViewById(R.id.Listview);
        users = new ArrayList<>();
        users.add(new User("Mahmoud","mahmoud@gmail.com","1234"));
        users.add(new User("lol","lol@gmail.com","4321"));
        arrayAdapter = new UserArrayAdapter(this, R.layout.listviewrow,users);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.signoutpop){
            mAuth.signOut();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        return true;
    }
}