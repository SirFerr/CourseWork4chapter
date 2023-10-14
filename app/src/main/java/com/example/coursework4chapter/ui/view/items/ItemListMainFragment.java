package com.example.coursework4chapter.ui.view.items;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.coursework4chapter.R;


public class ItemListMainFragment extends Fragment {

    View view;

    @Override
    public void onResume() {
        super.onResume();
        Button thereBtn = view.findViewById(R.id.btn1ItemMain);
        Button notThereBtn = view.findViewById(R.id.btn2ItemMain);

        notThereBtn.setEnabled(false);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_list_main, container, false);
        return view;
    }
}