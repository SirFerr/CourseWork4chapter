package com.example.coursework4chapter.data.students;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo
    String name;

    @ColumnInfo
    String group;

    public Student(int id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }
}
