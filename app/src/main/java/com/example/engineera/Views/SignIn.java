package com.example.engineera.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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
    EditText emailEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn=findViewById(R.id.services);
        emailEditText=findViewById(R.id.edittextemail);
        passwordEditText=findViewById(R.id.edittextpassword);
        btn.setOnClickListener(e ->
        {
            String email=emailEditText.getText().toString().trim();
            String password=passwordEditText.getText().toString().trim();
            if (email.isEmpty() && password.isEmpty())
            {
                Toast.makeText(this, "Email ou mot de passe invalide", Toast.LENGTH_SHORT).show();
            }
            else
            {
                new AuthenticateUserTask().execute(email, password);
            }

        });
        register=findViewById(R.id.backButton);

        register.setOnClickListener(e -> {
            Intent intent= new Intent(this, SignUp.class);
            startActivity(intent);}
                        );

    }

    private class AuthenticateUserTask extends AsyncTask<String, Void, User> {
        @Override
        protected User doInBackground(String... params) {
            String email = params[0];
            String password = params[1];
            return EngineeraDB.getAppDatabase(getApplicationContext()).userDao().getUser(email, password);
        }

        @Override
        protected void onPostExecute(User user) {
            if (user != null) {
                Toast.makeText(SignIn.this, "Login successful", Toast.LENGTH_SHORT).show();
                // User exists, proceed to MainActivity
                Intent intent = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(SignIn.this, "User not found. Please check your email and password.", Toast.LENGTH_SHORT).show();
                // User not found, do not proceed to MainActivity
            }
        }

    }
}