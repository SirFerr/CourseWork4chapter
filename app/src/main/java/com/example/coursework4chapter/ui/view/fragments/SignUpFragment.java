package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.coursework4chapter.R;


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

        signUpBtn.setOnClickListener(v -> {
            if (password.getText().toString().equals(confirmPassword.getText().toString()) && !email.getText().toString().equals("") && !name.getText().toString().equals("")) {


                Navigation.findNavController(v).popBackStack();
                Toast.makeText(requireContext(), "Регистрация успешна", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        return view;
    }
}