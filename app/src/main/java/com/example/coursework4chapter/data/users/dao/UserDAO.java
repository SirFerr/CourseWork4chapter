package com.example.coursework4chapter.data.users.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.users.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);
    @Delete
    void delete(User user);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAll();

    @Query("DELETE FROM users WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM users WHERE id = :id")
    User getUserById(int id);
    @Query("SELECT * FROM users WHERE email = :email")
    User getUserByEmail(String email);
}

