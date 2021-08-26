package com.example.makeupapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SwahiliAdapter extends RecyclerView.Adapter<SwahiliAdapter.SwahiliViewHolder> {

    Context context;
    ArrayList<SwahiliHelper> list;

    public SwahiliAdapter(Context context, ArrayList<SwahiliHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SwahiliAdapter.SwahiliViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.swahili,parent,false);
        return new SwahiliAdapter.SwahiliViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SwahiliAdapter.SwahiliViewHolder holder, int position) {

        SwahiliHelper swahiliHelper = list.get(position);
        holder.id.setText(swahiliHelper.getStudID());
        holder.name.setText(swahiliHelper.getStudName());

        holder.swa.setText(Integer.toString(swahiliHelper.getStudSwa()));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public static class SwahiliViewHolder extends RecyclerView.ViewHolder{

        TextView id, name, swa;
        public SwahiliViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.swaName);
            swa = itemView.findViewById(R.id.swaScore);
            id = itemView.findViewById(R.id.swaID);
        }
    }
}
