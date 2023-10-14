package com.example.coursework4chapter.data.attendences.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendances")
public class Attendance {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "student_id")
    int studentID;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "presence")
    Boolean wasPresent;

    public Attendance(int studentID, String date) {
        this.studentID = studentID;
        this.date = date;
        this.wasPresent = false;
    }
}
