package com.example.coursework4chapter.data.attendences.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendances")
public class Attendance {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    Long id;

    @ColumnInfo(name = "student_id")
    Long studentID;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "presence")
    Boolean wasPresent;

    public Attendance(Long studentID, String date) {
        this.studentID = studentID;
        this.date = date;
        this.wasPresent = false;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentID() {
        return studentID;
    }

    public String getDate() {
        return date;
    }

    public Boolean getWasPresent() {
        return wasPresent;
    }
}
