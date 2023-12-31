package com.example.coursework4chapter.data.studentsAttendance.students;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import com.example.coursework4chapter.data.studentsAttendance.attendance.Attendance;

import java.util.List;

@Entity(tableName = "student")
public class Student {
    @Relation(parentColumn = "id", entityColumn = "student_id", entity = Attendance.class)
    public List<Attendance> attendances;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "group_id")
    int groupId;

    public Student(String name, int groupId) {
        this.name = name;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGroupId() {
        return groupId;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }
}
