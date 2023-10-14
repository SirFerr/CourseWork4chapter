package com.example.coursework4chapter.data.students.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.attendences.model.Attendance;

import java.util.List;

@Entity(tableName = "students")
public class Student {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "group_id")
    String groupId;

    @Relation(parentColumn = "id", entityColumn = "studentID")
    public List<Attendance> attendances;

    public Student(String name, String groupId) {
        this.name = name;
        this.groupId = groupId;
    }
}
