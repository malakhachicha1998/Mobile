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
import com.example.engineera.Views.SignIn;

public class SignUp extends AppCompatActivity {
    TextView btn;
    Button btnregister;
    User user;
    UserRepository userRepository;
    EditText emailEditText, passwordEditText;
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
        emailEditText=findViewById(R.id.textemail);
        passwordEditText=findViewById(R.id.textpassword);

        btnregister.setOnClickListener(e ->

                {
                    String email=emailEditText.getText().toString().trim();
                    String password=passwordEditText.getText().toString().trim();
                    if (email.isEmpty() && password.isEmpty())
                    {
                        Toast.makeText(this, "Email ou mot de passe invalide", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        new CheckEmailTask().execute(email, password);
                    }
                }
        );

    }
    private class CheckEmailTask extends AsyncTask<String, Void, Boolean> {
        private String[] params;
        @Override
        protected Boolean doInBackground(String... params) {
            this.params = params; // Stored the parameters
            String email = params[0];
            String password = params[1];

            EngineeraDB userDatabase = EngineeraDB.getAppDatabase(getApplicationContext());
            UserDAO userDao = userDatabase.userDao();

            // Check if the email is already registered
            User existingUser = userDao.getUserByEmail(email);

            return existingUser == null;
        }

        @Override
        protected void onPostExecute(Boolean isEmailAvailable) {
            if (isEmailAvailable) {
                // Email is not registered, proceed with signup
                new SignUpTask().execute(params);
            } else {
                // Email is already registered
                Toast.makeText(SignUp.this, "Email already registered", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class SignUpTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            String email = params[0];
            String password = params[1];

            EngineeraDB userDatabase = EngineeraDB.getAppDatabase(getApplicationContext());
            UserDAO userDao = userDatabase.userDao();

            // Create a new user and insert into the database
            User newUser = new User(email, password);
            userDao.insertOne(newUser);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Signup successful
            Toast.makeText(SignUp.this, "Signup successful", Toast.LENGTH_SHORT).show();

            // Navigate to MainActivity or perform any other post-signup actions
            Intent intent = new Intent(SignUp.this, SignIn.class);
            startActivity(intent);
            finish();
        }
    }
}