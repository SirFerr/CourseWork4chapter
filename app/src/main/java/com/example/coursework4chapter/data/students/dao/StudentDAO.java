package com.example.coursework4chapter.data.students.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.coursework4chapter.data.attendences.model.Attendance;
import com.example.coursework4chapter.data.students.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllStudents(Student... students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student students);
    @Delete
    void deleteStudent(Student student);

    @Query("DELETE FROM students WHERE id = :id")
    void deleteStudentById(int id);

    @Query("DELETE FROM students WHERE name = :name")
    void deleteStudentByName(String name);

    @Query("SELECT * FROM students")
    LiveData<List<Student>> getAllStudents();


    @Query("SELECT * FROM students WHERE id = :id")
    LiveData<Student> getStudentById(int id);

    @Transaction
    @Query("SELECT * FROM students WHERE group_id IN (SELECT id FROM groups WHERE name = :groupName)")
    LiveData<List<Student>> getStudentsByGroupName(String groupName);

    @Query("SELECT * FROM students JOIN attendances ON attendances.student_id = students.id")
    LiveData<Map<Student, List<Attendance>>> loadStudentAndAttendances();

}
