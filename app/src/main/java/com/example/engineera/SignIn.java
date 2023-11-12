package com.example.engineera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    Button btn;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn=findViewById(R.id.button2);
        btn.setOnClickListener(e ->
                        Toast.makeText(this,"Vous êtes connecté",Toast.LENGTH_SHORT).show()
                );
        register=findViewById(R.id.register);
        Object Intent;
        register.setOnClickListener(e -> {
            Intent intent= new Intent(this,SignUp.class);
            startActivity(intent);}

                        );
    }
}