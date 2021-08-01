package com.example.butanogas.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView role;
        Button btnDelete;
        Button btnEdit;

        public ViewHolder(View itemView){
           super(itemView);
//            name = itemView.findViewById(R.id.textViewName);
//            role = itemView.findViewById(R.id.textViewrole);
//            btnDelete = itemView.findViewById(R.id.btnDelete);
//            btnEdit= itemView.findViewById(R.id.btnEdit);
        }
    }
}
