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

public class SignIn extends AppCompatActivity {

    Button btn;
    TextView register;
    UserRepository userRepository;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn=findViewById(R.id.services);
        user= new User();
        user.setEmail("aaaaaaaaaaa");
        user.setPassword("bbbbbbbbbb");
        btn.setOnClickListener(e ->
        {
            /*
            Toast.makeText(this, "Vous êtes connecté", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            */
            signIn(user);
        });
        register=findViewById(R.id.backButton);
        register.setOnClickListener(e -> {
            Intent intent= new Intent(this, SignUp.class);
            startActivity(intent);}

                        );
        UserDAO userDAO= EngineeraDB.getAppDatabase(this).userDao();
        userRepository= new UserRepository(userDAO);

    }
    private void signIn(User user) {
        Log.d("user in sign in",user.toString());
        User user1= new User();
        if (user1 == null) {
            Toast.makeText(this, "Sign in invalide", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sign in valide", Toast.LENGTH_SHORT).show();
        }
    }
}