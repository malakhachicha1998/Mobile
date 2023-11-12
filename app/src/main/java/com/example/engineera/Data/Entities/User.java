package com.example.engineera.Data.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
