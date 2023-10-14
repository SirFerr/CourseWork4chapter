package com.example.coursework4chapter.ui.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework4chapter.R;
import com.example.coursework4chapter.data.students.model.Student;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Student> students;
    private final OnStudentClickListener onClickListener;

    public StudentAdapter(Context context, List<Student> students, OnStudentClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.students = students;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_item_list_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.textItemMain.setText(student.getName());

        holder.btn1ItemMain.setOnClickListener(v -> onClickListener.onThereStudentClick(student, position));
        holder.btn2ItemMain.setOnClickListener(v -> onClickListener.onNotThereStudentClick(student, position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public interface OnStudentClickListener {
        void onThereStudentClick(Student student, int position);

        void onNotThereStudentClick(Student student, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textItemMain;
        final Button btn1ItemMain;
        final Button btn2ItemMain;

        ViewHolder(View view) {
            super(view);
            textItemMain = view.findViewById(R.id.textItemMain);
            btn1ItemMain = view.findViewById(R.id.btn1ItemMain);
            btn2ItemMain = view.findViewById(R.id.btn2ItemMain);
        }
    }
}
