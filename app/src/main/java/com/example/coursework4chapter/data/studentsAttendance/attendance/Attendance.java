package com.example.coursework4chapter.data.studentsAttendance.attendance;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendance")
public class Attendance {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "studentID")
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

    public int getId() {
        return id;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getDate() {
        return date;
    }

    public Boolean getWasPresent() {
        return wasPresent;
    }
}
