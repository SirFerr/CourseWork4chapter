package com.example.coursework4chapter.data.users.model;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.groups.model.Group;

import java.util.List;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    Long id;
    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "password")
    String password;
    @ColumnInfo(name = "name")
    String name;

    @Relation(parentColumn = "id", entityColumn = "user_id")
    public LiveData<List<Group>> groups;



    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
