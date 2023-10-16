package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework4chapter.R;
import com.example.coursework4chapter.ui.viewModel.StudentsAttendanceViewModel;


public class MainFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        RecyclerView studentList = view.findViewById(R.id.listStudentsMain);
        Button buttonAddStudent = view.findViewById(R.id.btnAddStudent);

        StudentsAttendanceViewModel studentsAttendanceViewModel = new ViewModelProvider(this).get(StudentsAttendanceViewModel.class);

//        studentsAttendanceViewModel.getStudentByGroupName(bundle.getString("groupName")).observe(this, students -> {
//            StudentAdapter.OnStudentClickListener onStudentClickListener = (state, position) -> {
//                Bundle bundle1 = new Bundle();
//                Student student = students.get(position);
//                bundle1.putString("studentID", String.valueOf(student.getId()));
//                bundle1.putString("studentName", student.getName());
//                Navigation.findNavController(view).navigate(R.id.action_groupFragment_to_mainFragment, bundle1);
//            };
//            studentList.setAdapter(new StudentAdapter(getContext(), students, onStudentClickListener));
//        });
        buttonAddStudent.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_addStudentFragment, bundle);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}