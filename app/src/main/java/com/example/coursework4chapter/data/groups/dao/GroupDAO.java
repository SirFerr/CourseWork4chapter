package com.example.coursework4chapter.data.groups.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.groups.model.Group;
import com.example.coursework4chapter.data.students.dao.StudentDAO;
import com.example.coursework4chapter.data.students.model.Student;

import java.util.List;

@Dao
public interface GroupDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllGroup(Group... groups);
    @Delete
    void deleteGroup(Group group);

    @Query("DELETE FROM groups WHERE id = :id")
    void deleteGroupById(int id);

    @Query("DELETE FROM groups WHERE name = :name")
    void deleteGroupByName(String name);

    @Query("SELECT * FROM groups")
    List<Student> getAllGroup();


    @Query("SELECT * FROM students WHERE id = :id")
    Student getGroupById(int id);
}
