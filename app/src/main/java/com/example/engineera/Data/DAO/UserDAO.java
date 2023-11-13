package com.example.engineera.Data.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.engineera.Data.Entities.User;

@Dao
public interface UserDAO {
    @Insert
    void insertOne(User user);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    User getUser(String email, String password);

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);
}
