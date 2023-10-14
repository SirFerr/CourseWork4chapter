package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework4chapter.R;


public class MainFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        RecyclerView studentList = view.findViewById(R.id.listStudentsMain);
        Button buttonAddStudent = view.findViewById(R.id.btnAddStudent);
        buttonAddStudent.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_addStudentFragment);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}