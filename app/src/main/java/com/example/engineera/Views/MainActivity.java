package com.example.engineera.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.engineera.Data.Database.EngineeraDB;
import com.example.engineera.Data.Entities.User;
import com.example.engineera.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnservice, btnstock, btnlogout;
    private EngineeraDB database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnservice=findViewById(R.id.services);
        btnservice.setOnClickListener(e-> {
            Toast.makeText(this,"Vous êtes dirigé vers la page des services",Toast.LENGTH_SHORT).show();
                    });

        btnstock=findViewById(R.id.stock);
        btnstock.setOnClickListener(e-> {
            Toast.makeText(this,"Vous êtes dirigé vers la page de stock",Toast.LENGTH_SHORT).show();
        });

        btnlogout=findViewById(R.id.logout);
        btnlogout.setOnClickListener(e ->
        {
            Toast.makeText(this,"Vous êtes déconnecté",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, SignIn.class);
            startActivity(intent);
            finish();
        });
    }
    /*void login(String email, String password) {
        if (email.equals("admin") && password.equals("123"))
    }

     */
}