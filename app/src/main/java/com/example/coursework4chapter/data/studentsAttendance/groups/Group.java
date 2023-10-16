package com.example.coursework4chapter.data.studentsAttendance.groups;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.studentsAttendance.students.Student;

import java.util.List;

@Entity(tableName = "group")
public class Group {
    @Relation(parentColumn = "id", entityColumn = "group_id")
    public List<Student> students;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "user_id")
    @NonNull
    int userId;

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public List<Student> getStudents() {
        return students;
    }
}
