package com.example.coursework4chapter.data.studentsAttendance.groups;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.studentsAttendance.students.Student;

import java.util.List;
import java.util.Map;

@Dao
public interface GroupDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllGroup(Group... groups);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGroup(Group group);

    @Delete
    void deleteGroup(Group group);

    @Query("DELETE FROM [group] WHERE id = :id")
    void deleteGroupById(int id);

    @Query("DELETE FROM [group] WHERE name = :name")
    void deleteGroupByName(String name);

    @Query("SELECT * FROM [group]")
    LiveData<List<Group>> getAllGroup();


    @Query("SELECT * FROM [group] WHERE id = :id")
    LiveData<Group> getGroupById(int id);

    @Query("SELECT * FROM [group] JOIN student ON student.group_id = [group].id")
    LiveData<Map<Group, List<Student>>> loadGroupAndStudents();
}
