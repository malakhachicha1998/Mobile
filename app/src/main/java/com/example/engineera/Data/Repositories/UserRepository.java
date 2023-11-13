package com.example.engineera.Data.Repositories;

import android.os.AsyncTask;
import android.util.Log;

import com.example.engineera.Data.DAO.OnSignInCompleteListener;
import com.example.engineera.Data.DAO.UserDAO;
import com.example.engineera.Data.Entities.User;
import com.example.engineera.Views.SignIn;

public class UserRepository {
    private UserDAO userDAO;
    public UserRepository (UserDAO userDAO)
    {
        this.userDAO= userDAO;
    }
    public void signIn (User user)
    {
        new SignInTask().execute(user);
    }
    private static class SignInTask extends AsyncTask<String,Void,User>
    {
        private UserDAO userDAO;
        private OnSignInCompleteListener listener;

        @Override
        protected User doInBackground(String... strings) {
            return null;
        }
    };


    public void signUp (String email, String password)
    {
        userDAO.insertOne(new User(email,password));
    }
}
