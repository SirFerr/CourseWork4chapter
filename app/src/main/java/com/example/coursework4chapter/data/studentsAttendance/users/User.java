package com.example.coursework4chapter.data.studentsAttendance.users;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.studentsAttendance.groups.Group;

import java.util.List;

@Entity(tableName = "user")
public class User {
    @Relation(parentColumn = "id", entityColumn = "user_id", entity = Group.class)
    public LiveData<List<Group>> groups = null;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "password")
    String password;
    @ColumnInfo(name = "name")
    String name;


    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LiveData<List<Group>> getGroups() {
        return groups;
    }
}
