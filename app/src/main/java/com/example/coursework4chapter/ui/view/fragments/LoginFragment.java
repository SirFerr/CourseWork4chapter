package com.example.coursework4chapter.ui.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.coursework4chapter.R;


public class LoginFragment extends Fragment {

    View view;


    @Override
    public void onResume() {
        super.onResume();
        EditText email= view.findViewById(R.id.editTextEmailLogin);
        EditText password= view.findViewById(R.id.editTextPasswordLogin);
        Button login = view.findViewById(R.id.btnLoginLogin);
        Button signup = view.findViewById(R.id.btnSignUpLogin);

        signup.setOnClickListener(v->{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }
}