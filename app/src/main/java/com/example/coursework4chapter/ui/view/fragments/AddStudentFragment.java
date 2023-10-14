package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.coursework4chapter.R;


public class AddStudentFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        EditText student = view.findViewById(R.id.editTextNameAddStudent);
        Button addBtn = view.findViewById(R.id.btnAddStudent);

        addBtn.setOnClickListener(v -> {
            if (!student.getText().toString().equals("")) {
                Navigation.findNavController(v).popBackStack();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_student, container, false);
        return view;
    }
}