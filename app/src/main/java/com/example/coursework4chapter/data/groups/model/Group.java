package com.example.coursework4chapter.data.groups.model;

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
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "user_id")
    int userId;

    @Relation(parentColumn = "id", entityColumn = "group_id")
    public List<Student> students;
    public Group(String name) {
        this.name = name;
    }
}
