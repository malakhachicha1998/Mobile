package com.example.engineera.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engineera.R;

public class SignIn extends AppCompatActivity {

    Button btn;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn=findViewById(R.id.services);
        btn.setOnClickListener(e ->
        {
            Toast.makeText(this, "Vous êtes connecté", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        register=findViewById(R.id.backButton);
        Object Intent;
        register.setOnClickListener(e -> {
            Intent intent= new Intent(this, SignUp.class);
            startActivity(intent);}

                        );
    }
}