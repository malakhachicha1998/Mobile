package com.example.engineera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn=findViewById(R.id.backbutton);
        btn.setOnClickListener(e ->
                {
                    Intent intent=new Intent(this,SignIn.class);
                    startActivity(intent);
                }
                );
    }
}