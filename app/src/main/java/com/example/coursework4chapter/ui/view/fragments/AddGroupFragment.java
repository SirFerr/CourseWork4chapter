package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.coursework4chapter.R;
import com.example.coursework4chapter.data.studentsAttendance.groups.Group;
import com.example.coursework4chapter.ui.viewModel.StudentsAttendanceViewModel;


public class AddGroupFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        EditText group = view.findViewById(R.id.editTextGroupAddGroup);
        Button addBtn = view.findViewById(R.id.btnAddAddGroup);
        StudentsAttendanceViewModel studentsAttendanceViewModel = new ViewModelProvider(this).get(StudentsAttendanceViewModel.class);


        addBtn.setOnClickListener(v -> {

            if (!group.getText().toString().equals("")) {
                studentsAttendanceViewModel.insertGroup(new Group(group.getText().toString()));
                Toast.makeText(requireContext(), "Группа успешно добавленна", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).popBackStack();
            } else
                Toast.makeText(requireContext(), "Заполнены не все поля", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_group, container, false);
        return view;
    }
}