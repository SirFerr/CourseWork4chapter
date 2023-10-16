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
import com.example.coursework4chapter.data.studentsAttendance.users.User;
import com.example.coursework4chapter.ui.viewModel.StudentsAttendanceViewModel;


public class LoginFragment extends Fragment {

    View view;


    @Override
    public void onResume() {
        super.onResume();
        EditText email = view.findViewById(R.id.editTextEmailLogin);
        EditText password = view.findViewById(R.id.editTextPasswordLogin);
        Button login = view.findViewById(R.id.btnLoginLogin);
        Button signup = view.findViewById(R.id.btnSignUpLogin);

        StudentsAttendanceViewModel studentsAttendanceViewModel = new ViewModelProvider(this).get(StudentsAttendanceViewModel.class);

        login.setOnClickListener(v -> {
            if (!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                User user = studentsAttendanceViewModel.getUserByEmail(email.getText().toString()).getValue();
                if (password.getText().toString().equals(user.getPassword())) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("UserID", user.getId());
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_groupFragment, bundle);
                } else
                    Toast.makeText(requireContext(), "Пользователя не существует", Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(requireContext(), "Заполнены не все поля", Toast.LENGTH_SHORT).show();
        });
        signup.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment);
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }
}