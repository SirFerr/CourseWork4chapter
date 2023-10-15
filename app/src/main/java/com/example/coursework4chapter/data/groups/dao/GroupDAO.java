package com.example.coursework4chapter.data.groups.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursework4chapter.data.groups.model.Group;
import com.example.coursework4chapter.data.students.model.Student;

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

    @Query("DELETE FROM groups WHERE id = :id")
    void deleteGroupById(int id);

    @Query("DELETE FROM groups WHERE name = :name")
    void deleteGroupByName(String name);

    @Query("SELECT * FROM groups")
    LiveData<List<Group>> getAllGroup();


    @Query("SELECT * FROM groups WHERE id = :id")
    LiveData<Group> getGroupById(int id);

    @Query("SELECT * FROM groups JOIN students ON students.group_id = groups.id")
    LiveData<Map<Group, List<Student>>> loadGroupAndStudents();
}
