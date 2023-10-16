package com.example.coursework4chapter.ui.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework4chapter.R;
import com.example.coursework4chapter.data.studentsAttendance.groups.Group;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Group> groups;
    private final OnGroupClickListener onClickListener;

    public GroupAdapter(Context context, List<Group> groups, OnGroupClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.groups = groups;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_item_group_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Group group = groups.get(position);
        holder.textItemGroup.setText(group.getName());
        holder.itemView.setOnClickListener(v -> onClickListener.onGroupClick(group, position));
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public interface OnGroupClickListener {
        void onGroupClick(Group group, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textItemGroup;

        ViewHolder(View view) {
            super(view);
            textItemGroup = view.findViewById(R.id.textItemGroup);
        }
    }
}
