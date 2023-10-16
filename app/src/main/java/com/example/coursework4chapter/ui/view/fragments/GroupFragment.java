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
import com.example.coursework4chapter.data.studentsAttendance.groups.Group;
import com.example.coursework4chapter.ui.view.adapters.GroupAdapter;
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
            GroupAdapter.OnGroupClickListener onGroupClickListener = (state, position) -> {
                Bundle bundle1 = new Bundle();
                Group group = groups.get(position);
                bundle1.putString("groupID", String.valueOf(group.getId()));
                bundle1.putString("groupName", group.getName());
                Navigation.findNavController(view).navigate(R.id.action_groupFragment_to_mainFragment, bundle1);
            };
            groupList.setAdapter(new GroupAdapter(getContext(), groups, onGroupClickListener));
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