package com.example.appeducation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private Button button;
    private TextView name ;
    private TextView password ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button)findViewById(R.id.loginbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, ListeCours.class);
        name = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        String nom = name.getText().toString();
        String mdp = password.getText().toString();
        intent.putExtra("keyName",nom);
        intent.putExtra("keyPassword",mdp);
        startActivity(intent);
    }
}