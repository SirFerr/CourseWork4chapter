package com.example.coursework4chapter.data.students.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.students.model.Student;

import java.util.List;

public interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllStudents(Student... students);
    @Delete
    void deleteStudent(Student student);

    @Query("DELETE FROM students WHERE id = :id")
    void deleteStudentById(int id);

    @Query("DELETE FROM students WHERE name = :name")
    void deleteStudentByName(String name);

    @Query("SELECT * FROM students")
    List<Student> getAllStudent();


    @Query("SELECT * FROM students WHERE id = :id")
    Student getStudentById(int id);

}
