package com.example.coursework4chapter.data.users.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.groups.model.Group;
import com.example.coursework4chapter.data.users.model.User;

import java.util.List;
import java.util.Map;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUsers(User... users);
    @Delete
    void deleteUser(User user);


    @Query("SELECT * FROM groups WHERE user_id = :userId")
    LiveData<List<Group>> getGroupsByUserId(int userId);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();

    @Query("DELETE FROM users WHERE id = :id")
    void deleteUserById(int id);

    @Query("SELECT * FROM users WHERE id = :id")
    LiveData<User> getUserById(int id);
    @Query("SELECT * FROM users WHERE email = :email")
    LiveData<User> getUserByEmail(String email);

    @Query("SELECT * FROM users JOIN groups ON groups.user_id = users.id")
    LiveData<Map<User, List<Group>>> loadUserAndGroups();

    @Query("INSERT INTO users (email, password, name) VALUES (:email, :password, :name)")
    void insertUser(String email, String password, String name);


}

