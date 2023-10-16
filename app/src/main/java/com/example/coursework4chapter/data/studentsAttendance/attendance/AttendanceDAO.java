package com.example.coursework4chapter.data.studentsAttendance.attendance;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AttendanceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllAttendance(Attendance... attendances);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAttendance(Attendance attendance);

    @Query("SELECT * FROM attendance")
    LiveData<List<Attendance>> getAllAttendance();

    @Query("UPDATE attendance SET presence = :wasPresent WHERE student_id = :studentId")
    void updateAttendance(boolean wasPresent, int studentId);
}
