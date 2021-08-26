package com.example.makeupapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MathAdapter extends RecyclerView.Adapter<MathAdapter.MathViewHolder> {

    Context context;
    ArrayList<MathHelper> list;

    public MathAdapter(Context context, ArrayList<MathHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MathAdapter.MathViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.math,parent,false);
        return new MathAdapter.MathViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MathAdapter.MathViewHolder holder, int position) {

        MathHelper mathHelper = list.get(position);
        holder.id.setText(mathHelper.getStudID());
        holder.name.setText(mathHelper.getStudName());

        holder.math.setText(Integer.toString(mathHelper.getStudMath()));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public static class MathViewHolder extends RecyclerView.ViewHolder{

        TextView id, name, math;
        public MathViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.mathID);
            name = itemView.findViewById(R.id.mathName);
            math = itemView.findViewById(R.id.mathScore);
        }
    }
}
