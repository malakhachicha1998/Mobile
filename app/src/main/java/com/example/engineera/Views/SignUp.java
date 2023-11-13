package com.example.engineera.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.engineera.Data.DAO.UserDAO;
import com.example.engineera.Data.Database.EngineeraDB;
import com.example.engineera.Data.Entities.User;
import com.example.engineera.Data.Repositories.UserRepository;
import com.example.engineera.R;
import com.example.engineera.Views.SignIn;

public class SignUp extends AppCompatActivity {
    TextView btn;
    Button btnregister;
    User user;
    UserRepository userRepository;
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
        UserDAO userDAO= EngineeraDB.getAppDatabase(this).userDao();
        userRepository= new UserRepository(userDAO);

        btnregister.setOnClickListener(e ->
                {
                    user= new User();
                    user.setEmail("aaaaaaaaaaa");
                    user.setPassword("bbbbbbbbbb");
                    /*
                    Toast.makeText(this,"Votre compte a été créé", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(this,SignIn.class);
                    startActivity(intent);
                     */
                signUp(user);
                }
        );

    }
    private void signUp(User user){
        Log.d("User in sign up",user.toString());
        userRepository.signUp(user.getEmail(),user.getPassword());
        Log.d("user created",userRepository.signIn(user.getEmail(), user.getPassword()).toString());
        Toast.makeText(this, "User created", Toast.LENGTH_SHORT).show();

    }
}