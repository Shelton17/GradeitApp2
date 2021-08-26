package com.example.makeupapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishAdapter.EnglishViewHolder> {

    Context context;
    ArrayList<EnglishHelper> list;

    public EnglishAdapter(Context context, ArrayList<EnglishHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EnglishAdapter.EnglishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.english,parent,false);
        return new EnglishAdapter.EnglishViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EnglishAdapter.EnglishViewHolder holder, int position) {

        EnglishHelper englishHelper = list.get(position);
        holder.id.setText(englishHelper.getStudID());
        holder.name.setText(englishHelper.getStudName());

        holder.eng.setText(Integer.toString(englishHelper.getStudEng()));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public static class EnglishViewHolder extends RecyclerView.ViewHolder{

        TextView id, name, eng;
        public EnglishViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.engID);
            name = itemView.findViewById(R.id.engName);
            eng = itemView.findViewById(R.id.engScore);
        }
    }
}
