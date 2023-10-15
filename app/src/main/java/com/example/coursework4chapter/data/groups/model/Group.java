package com.example.coursework4chapter.data.groups.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.students.model.Student;

import java.util.List;

@Entity(tableName = "groups")
public class Group {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    Long id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "user_id")
    @NonNull
    Long userId;

    @Relation(parentColumn = "id", entityColumn = "group_id")
    public LiveData<List<Student>> students;


    public Group(String name, @NonNull Long userId) {
        this.name = name;
        this.userId = userId;
    }

}