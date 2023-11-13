package com.example.engineera.Data.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.engineera.Data.DAO.UserDAO;
import com.example.engineera.Data.Entities.User;

@Database(entities = {User.class}, version = 2, exportSchema = false)
public abstract class EngineeraDB extends RoomDatabase {
    private static EngineeraDB instance;
    public abstract UserDAO userDao();
    public static EngineeraDB getAppDatabase(Context context) {
        if (instance ==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            EngineeraDB.class, "room_test_db")
                    .addMigrations()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
