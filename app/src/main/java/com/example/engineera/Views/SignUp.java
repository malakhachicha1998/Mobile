package com.example.engineera.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engineera.R;
import com.example.engineera.Views.SignIn;

public class SignUp extends AppCompatActivity {
    TextView btn;
    Button btnregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn=findViewById(R.id.backButton);
        btn.setOnClickListener(e ->
                {
                    Intent intent=new Intent(this, SignIn.class);
                    startActivity(intent);
                }
                );
        btnregister=findViewById(R.id.services);
        btnregister.setOnClickListener(e ->
                {
                    Toast.makeText(this,"Votre compte a été créé", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(this,SignIn.class);
                    startActivity(intent);
                }
        );
    }
}