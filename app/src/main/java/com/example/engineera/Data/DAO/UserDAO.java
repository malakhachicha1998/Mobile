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

    @Query("SELECT * FROM USER_TABLE WHERE email LIKE :email AND password LIKE :password")
    User getUser(String email, String password);

}
