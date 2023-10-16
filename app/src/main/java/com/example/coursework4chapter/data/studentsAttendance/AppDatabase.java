package com.example.coursework4chapter.data.studentsAttendance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coursework4chapter.data.studentsAttendance.attendance.Attendance;
import com.example.coursework4chapter.data.studentsAttendance.attendance.AttendanceDAO;
import com.example.coursework4chapter.data.studentsAttendance.groups.Group;
import com.example.coursework4chapter.data.studentsAttendance.groups.GroupDAO;
import com.example.coursework4chapter.data.studentsAttendance.students.Student;
import com.example.coursework4chapter.data.studentsAttendance.students.StudentDAO;
import com.example.coursework4chapter.data.studentsAttendance.users.User;
import com.example.coursework4chapter.data.studentsAttendance.users.UserDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Group.class, Student.class, Attendance.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //Maybe 6
    private static final int NUMBER_OF_THREADS = 10;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile AppDatabase INSTANCE;

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

    public abstract UserDAO getUserDAO();

    public abstract GroupDAO getGroupDAO();

    public abstract StudentDAO getStudentDAO();

    public abstract AttendanceDAO getAttendanceDAO();
}
