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
import com.example.coursework4chapter.ui.viewModel.StudentsAttendanceViewModel;


public class SignUpFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        EditText email = view.findViewById(R.id.editTextEmailSignUp);
        EditText name = view.findViewById(R.id.editTextNameSignUp);
        EditText password = view.findViewById(R.id.editTextPasswordSignUp);
        EditText confirmPassword = view.findViewById(R.id.editTextConfirmPasswordSignUp);
        Button signUpBtn = view.findViewById(R.id.btnSignUpSignUp);

        StudentsAttendanceViewModel studentsAttendanceViewModel = new ViewModelProvider(this).get(StudentsAttendanceViewModel.class);

        signUpBtn.setOnClickListener(v -> {
            if (!email.getText().toString().equals("") && !name.getText().toString().equals("") && !password.getText().toString().equals("") && !confirmPassword.getText().toString().equals("")) {
                if (password.getText().toString().equals(confirmPassword.getText().toString())) {

                    studentsAttendanceViewModel.insertUser(email.getText().toString(), password.getText().toString(), name.getText().toString());

                    Toast.makeText(requireContext(), "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).popBackStack();
                } else
                    Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(requireContext(), "Заполнены не все поля", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        return view;
    }
}