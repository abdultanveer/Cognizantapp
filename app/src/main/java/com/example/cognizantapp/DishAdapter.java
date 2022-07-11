package com.example.cognizantapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//holder = reserve
//DishAdapter.DishViewHolder = inner class
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {


    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DishViewHolder extends RecyclerView.ViewHolder {
        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
