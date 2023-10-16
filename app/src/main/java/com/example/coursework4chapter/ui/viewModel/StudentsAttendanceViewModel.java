package com.example.coursework4chapter.ui.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coursework4chapter.data.studentsAttendance.Repository;
import com.example.coursework4chapter.data.studentsAttendance.attendance.Attendance;
import com.example.coursework4chapter.data.studentsAttendance.groups.Group;
import com.example.coursework4chapter.data.studentsAttendance.students.Student;
import com.example.coursework4chapter.data.studentsAttendance.users.User;

import java.util.List;
import java.util.Map;

public class StudentsAttendanceViewModel extends AndroidViewModel {

    private final Repository mRepository;
    private final LiveData<List<User>> mAllUser;
    private final LiveData<List<Group>> mAllGroup;
    private final LiveData<List<Student>> mAllStudent;
    private final LiveData<List<Attendance>> mAllAttendance;

    public StudentsAttendanceViewModel(Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllUser = mRepository.getAllUsers();
        mAllGroup = mRepository.getAllGroups();
        mAllStudent = mRepository.getAllStudents();
        mAllAttendance = mRepository.getAllAttendances();
    }

    public LiveData<List<User>> getAllUser() {
        return mAllUser;
    }

    public LiveData<List<Group>> getAllGroup() {
        return mAllGroup;
    }

    public LiveData<List<Student>> getAllStudent() {
        return mAllStudent;
    }

    public LiveData<List<Attendance>> getAllAttendance() {
        return mAllAttendance;
    }

    public void insertAttendance(Attendance... attendances) {
        mRepository.insertAttendance(attendances);
    }

    public void insertAttendance(Attendance attendances) {
        mRepository.insertAttendance(attendances);
    }

    public void updateAttendance(boolean wasPresent, int studentId) {
        mRepository.updateAttendance(wasPresent, studentId);
    }

    public void insertAllGroup(Group... groups) {
        mRepository.insertAllGroup(groups);
    }

    public void insertGroup(Group group) {
        mRepository.insertGroup(group);
    }

    public void deleteGroup(Group group) {
        mRepository.deleteGroup(group);
    }

    public void deleteGroupById(int id) {
        mRepository.deleteGroupById(id);
    }

    public void deleteGroupByName(String name) {
        mRepository.deleteGroupByName(name);
    }

    public LiveData<Group> getGroupById(int id) {
        return mRepository.getGroupById(id);
    }

    public LiveData<Map<Group, List<Student>>> loadGroupAndStudents() {
        return mRepository.loadGroupAndStudents();
    }

    public void insertAllStudents(Student... students) {
        mRepository.insertAllStudents(students);
    }

    public void insertStudent(Student student) {
        mRepository.insertStudent(student);
    }

    public void deleteStudent(Student student) {
        mRepository.deleteStudent(student);
    }

    public void deleteStudentById(int id) {
        mRepository.deleteStudentById(id);
    }

    public void deleteStudentByName(String name) {
        mRepository.deleteStudentByName(name);
    }

    public LiveData<Student> getStudentById(int id) {
        return mRepository.getStudentById(id);
    }

    public LiveData<List<Student>> getStudentByGroupName(String groupName) {
        return mRepository.getStudentByGroupName(groupName);
    }

    public LiveData<Map<Student, List<Attendance>>> loadStudentAndAttendances() {
        return mRepository.loadStudentAndAttendances();
    }

    public void insertAllUsers(User... users) {
        mRepository.insertAllUsers(users);
    }

    public void deleteUser(User user) {
        mRepository.deleteUser(user);
    }

    public LiveData<List<Group>> getGroupsByUserId(int userId) {
        return mRepository.getGroupsByUserId(userId);
    }

    public void deleteUserById(int id) {
        mRepository.deleteUserById(id);
    }

    public LiveData<User> getUserById(int id) {
        return mRepository.getUserById(id);
    }

    public LiveData<User> getUserByEmail(String email) {
        return mRepository.getUserByEmail(email);
    }

    public LiveData<Map<User, List<Group>>> loadUserAndGroups() {
        return mRepository.loadUserAndGroups();
    }

    public void insertUser(String email, String password, String name) {
        mRepository.insertUser(email, password, name);
    }
}
