package com.example.coursework4chapter.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coursework4chapter.data.attendences.dao.AttendanceDAO;
import com.example.coursework4chapter.data.attendences.model.Attendance;
import com.example.coursework4chapter.data.groups.dao.GroupDAO;
import com.example.coursework4chapter.data.groups.model.Group;
import com.example.coursework4chapter.data.students.dao.StudentDAO;
import com.example.coursework4chapter.data.students.model.Student;
import com.example.coursework4chapter.data.users.dao.UserDAO;
import com.example.coursework4chapter.data.users.model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Group.class, Student.class, Attendance.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO getUserDAO();

    public abstract GroupDAO getGroupDAO();

    public abstract StudentDAO getStudentDAO();

    public abstract AttendanceDAO getAttendanceDAO();

    //Maybe 6
    private static final int NUMBER_OF_THREADS = 10;
    private static volatile AppDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized AppDatabase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
