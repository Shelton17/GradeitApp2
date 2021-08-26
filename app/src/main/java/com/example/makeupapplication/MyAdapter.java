package com.example.makeupapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Students> list;

    public MyAdapter(Context context, ArrayList<Students> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Students students = list.get(position);
        holder.name.setText(students.getStudName());
        holder.id.setText(students.getStudID());
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tName);
            id = itemView.findViewById(R.id.tID);
        }
    }
}
