package com.example.coursework4chapter.data.groups.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.students.model.Student;

import java.util.List;

@Entity(tableName = "groups")
public class Group {
    @Relation(parentColumn = "id", entityColumn = "group_id")
    public List<Student> students;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    Long id;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "user_id")
    @NonNull
    Long userId;

    public Group(String name, @NonNull Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Student> getStudents() {
        return students;
    }
}
