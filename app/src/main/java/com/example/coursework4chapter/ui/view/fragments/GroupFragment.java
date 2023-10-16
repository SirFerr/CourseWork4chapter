package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework4chapter.R;
import com.example.coursework4chapter.ui.viewModel.StudentsAttendanceViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class GroupFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        RecyclerView groupList = view.findViewById(R.id.listGroupGroup);
        FloatingActionButton buttonAddGroup = view.findViewById(R.id.btnAddGroup);


        StudentsAttendanceViewModel studentsAttendanceViewModel = new ViewModelProvider(this).get(StudentsAttendanceViewModel.class);

        Bundle bundle = getArguments();

        studentsAttendanceViewModel.getGroupsByUserId(bundle.getInt("UserID")).observe(this, groups -> {
//            groupList.setAdapter();
        });

        buttonAddGroup.setOnClickListener(v ->
        {
            Navigation.findNavController(v).navigate(R.id.action_groupFragment_to_addGroupFragment);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_group, container, false);
        return view;
    }
}