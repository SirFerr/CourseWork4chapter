package com.example.coursework4chapter.data.studentsAttendance.students;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.coursework4chapter.data.studentsAttendance.attendance.Attendance;

import java.util.List;
import java.util.Map;

public interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllStudents(Student... students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student students);

    @Delete
    void deleteStudent(Student student);

    @Query("DELETE FROM student WHERE id = :id")
    void deleteStudentById(int id);

    @Query("DELETE FROM student WHERE name = :name")
    void deleteStudentByName(String name);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAllStudents();


    @Query("SELECT * FROM student WHERE id = :id")
    LiveData<Student> getStudentById(int id);

    @Transaction
    @Query("SELECT * FROM student WHERE group_id IN (SELECT id FROM [group] WHERE name = :groupName)")
    LiveData<List<Student>> getStudentsByGroupName(String groupName);

    @Query("SELECT * FROM student JOIN attendance ON attendance.student_id = student.id")
    LiveData<Map<Student, List<Attendance>>> loadStudentAndAttendances();

}
