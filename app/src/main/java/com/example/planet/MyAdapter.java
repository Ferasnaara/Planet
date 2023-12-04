package com.example.planet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    ArrayList<Planet> list;
    Context context ;

    public MyAdapter(Context context, ArrayList<Planet> list) {
        this.context = context;
        list = list;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<Planet> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Planet product=list.get(position);
        holder.Name.setText(product.getClass().getModifiers());
    }
    @Override
    public int getItemCount()
    {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        ImageView proPicture;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.btnSignupSignup);
            proPicture=itemView.findViewById(R.id.btnBackSignup);
        }
    }
}
