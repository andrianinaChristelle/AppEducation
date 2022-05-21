package com.example.appeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        imageButton = (ImageButton)findViewById(R.id.idChiffre);
        String username= getIntent().getStringExtra("keyName");
        String password = getIntent().getStringExtra("keyPassword");
        Log.println(Log.VERBOSE,"Tag",username);
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
        System.out.println("nomm"+username);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Cours.class);
        startActivity(intent);
    }
}