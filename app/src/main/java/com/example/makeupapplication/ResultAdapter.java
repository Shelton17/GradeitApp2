package com.example.makeupapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    Context context;
    ArrayList<ResultHelper> list;

    public ResultAdapter(Context context, ArrayList<ResultHelper> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.result,parent,false);
        return new ResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {

        ResultHelper resultHelper = list.get(position);
        holder.id.setText(resultHelper.getStudID());
        holder.name.setText(resultHelper.getStudName());
        String holdMat, holdSwa, holdEng;
        holdMat = Integer.toString(resultHelper.getStudMath());
        holdSwa = Integer.toString(resultHelper.getStudSwa());
        holdEng = Integer.toString(resultHelper.getStudEng());

        int holdTotal = Integer.valueOf(holdMat) + Integer.valueOf(holdEng) + Integer.valueOf(holdSwa);
        Log.i("t", String.valueOf(holdTotal));
        holder.math.setText(Integer.toString(resultHelper.getStudMath()));
        holder.eng.setText(Integer.toString(resultHelper.getStudEng()));
        holder.swa.setText(Integer.toString(resultHelper.getStudSwa()));
        holder.total.setText(Integer.toString(holdTotal));
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public static class ResultViewHolder extends RecyclerView.ViewHolder{

        TextView name, total, id, math, eng, swa;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.resultID);
            name = itemView.findViewById(R.id.resultName);
            math = itemView.findViewById(R.id.resultMath);
            eng = itemView.findViewById(R.id.resultEng);
            swa = itemView.findViewById(R.id.resultSwa);
            total = itemView.findViewById(R.id.resultTotal);
        }
    }
}
