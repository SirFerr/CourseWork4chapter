package com.example.coursework4chapter.data.attendences;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Attendance {
    @ColumnInfo
    int studentID;

    @ColumnInfo
    String date;

    public Attendance(int studentID, String date) {
        this.studentID = studentID;
        this.date = date;
    }
}
