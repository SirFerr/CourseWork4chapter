package com.example.coursework4chapter.data.studentsAttendance.users;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.studentsAttendance.groups.Group;

import java.util.List;
import java.util.Map;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUsers(User... users);

    @Delete
    void deleteUser(User user);


    @Query("SELECT * FROM [group] WHERE user_id = :userId")
    LiveData<List<Group>> getGroupsByUserId(int userId);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();

    @Query("DELETE FROM user WHERE id = :id")
    void deleteUserById(int id);

    @Query("SELECT * FROM user WHERE id = :id")
    LiveData<User> getUserById(int id);

    @Query("SELECT * FROM user WHERE email = :email")
    LiveData<User> getUserByEmail(String email);

    @Query("SELECT * FROM user JOIN [group] ON [group].user_id = user.id")
    LiveData<Map<User, List<Group>>> loadUserAndGroups();

    @Query("INSERT INTO user (email, password, name) VALUES (:email, :password, :name)")
    void insertUser(String email, String password, String name);


}

