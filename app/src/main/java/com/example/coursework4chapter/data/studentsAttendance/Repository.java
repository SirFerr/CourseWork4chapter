package com.example.coursework4chapter.data.studentsAttendance;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.coursework4chapter.data.studentsAttendance.attendance.Attendance;
import com.example.coursework4chapter.data.studentsAttendance.attendance.AttendanceDAO;
import com.example.coursework4chapter.data.studentsAttendance.groups.Group;
import com.example.coursework4chapter.data.studentsAttendance.groups.GroupDAO;
import com.example.coursework4chapter.data.studentsAttendance.students.Student;
import com.example.coursework4chapter.data.studentsAttendance.students.StudentDAO;
import com.example.coursework4chapter.data.studentsAttendance.users.User;
import com.example.coursework4chapter.data.studentsAttendance.users.UserDAO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class Repository {
    private final AttendanceDAO attendanceDAO;
    private final GroupDAO groupDAO;

    private final StudentDAO studentDAO;

    private final UserDAO userDAO;

    private final LiveData<List<Group>> allGroups;
    private final LiveData<List<Student>> allStudents;
    private final LiveData<List<User>> allUsers;

    private final LiveData<List<Attendance>> allAttendances;

    public Repository(Application application) {
        AppDatabase db = AppDatabase.getDataBase(application);

        attendanceDAO = db.getAttendanceDAO();
        groupDAO = db.getGroupDAO();
        studentDAO = db.getStudentDAO();
        userDAO = db.getUserDAO();

        allGroups = groupDAO.getAllGroup();
        allStudents = studentDAO.getAllStudents();
        allUsers = userDAO.getAllUsers();
        allAttendances = attendanceDAO.getAllAttendance();

    }

    private <T> LiveData<T> executeAsync(Supplier<LiveData<T>> supplier) {
        CompletableFuture<LiveData<T>> future = CompletableFuture
                .supplyAsync(supplier, AppDatabase.databaseWriteExecutor);
        return future.exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join();
    }


    public LiveData<List<Group>> getAllGroups() {
        return allGroups;
    }

    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<List<Attendance>> getAllAttendances() {
        return allAttendances;
    }

    public void insertAttendance(Attendance... attendances) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> attendanceDAO.insertAllAttendance(attendances));
    }

    public void insertAttendance(Attendance attendances) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> attendanceDAO.insertAttendance(attendances));
    }

    public void updateAttendance(boolean wasPresent, int studentId) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> attendanceDAO.updateAttendance(wasPresent, studentId));
    }

    public void insertAllGroup(Group... groups) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> groupDAO.insertAllGroup(groups));
    }

    public void insertGroup(Group group) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> groupDAO.insertGroup(group));
    }

    public void deleteGroup(Group group) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> groupDAO.deleteGroup(group));
    }

    public void deleteGroupById(int id) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> groupDAO.deleteGroupById(id));
    }

    public void deleteGroupByName(String name) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> groupDAO.deleteGroupByName(name));
    }

    public LiveData<Group> getGroupById(int id) {
        return executeAsync(() -> groupDAO.getGroupById(id));
    }

    public LiveData<Map<Group, List<Student>>> loadGroupAndStudents() {
        return executeAsync(() -> groupDAO.loadGroupAndStudents());
    }

    public void insertAllStudents(Student... students) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> studentDAO.insertAllStudents(students));
    }

    public void insertStudent(Student student) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> studentDAO.insertStudent(student));
    }

    public void deleteStudent(Student student) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> studentDAO.deleteStudent(student));
    }

    public void deleteStudentById(int id) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> studentDAO.deleteStudentById(id));
    }

    public void deleteStudentByName(String name) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> studentDAO.deleteStudentByName(name));
    }

    public LiveData<Student> getStudentById(int id) {
        return executeAsync(() -> studentDAO.getStudentById(id));
    }

    public LiveData<List<Student>> getStudentByGroupName(String groupName) {
        return executeAsync(() -> studentDAO.getStudentsByGroupName(groupName));
    }

    public LiveData<Map<Student, List<Attendance>>> loadStudentAndAttendances() {
        return executeAsync(() -> studentDAO.loadStudentAndAttendances());
    }

    public void insertAllUsers(User... users) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> userDAO.insertAllUsers(users));
    }

    public void deleteUser(User user) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> userDAO.deleteUser(user));
    }

    public LiveData<List<Group>> getGroupsByUserId(int userId) {
        return executeAsync(() -> userDAO.getGroupsByUserId(userId));
    }

    public void deleteUserById(int id) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> userDAO.deleteUserById(id));
    }

    public LiveData<User> getUserById(int id) {
        return executeAsync(() -> userDAO.getUserById(id));
    }

    public LiveData<User> getUserByEmail(String email) {
        return executeAsync(() -> userDAO.getUserByEmail(email));
    }

    public LiveData<Map<User, List<Group>>> loadUserAndGroups() {
        return executeAsync(() -> userDAO.loadUserAndGroups());
    }

    public void insertUser(String email, String password, String name) {
        AppDatabase.databaseWriteExecutor
                .execute(() -> userDAO.insertUser(email, password, name));
    }

}
