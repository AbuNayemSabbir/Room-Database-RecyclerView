package com.example.roomdatbase_r_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    List<User> users;
    public myAdapter(List<User> users) {
        this.users = users;
    }



    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerodesign,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position) {
        holder.rUserId.setText(String.valueOf(users.get(position).getUid()));
        holder.rFirstName.setText(users.get(position).getFirstName());
        holder.rLastName.setText(users.get(position).getLastName());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView rUserId,rFirstName,rLastName;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            rUserId=itemView.findViewById(R.id.rUserId);
            rFirstName=itemView.findViewById(R.id.rFirstName);
            rLastName=itemView.findViewById(R.id.rLastName);
        }
    }

}
