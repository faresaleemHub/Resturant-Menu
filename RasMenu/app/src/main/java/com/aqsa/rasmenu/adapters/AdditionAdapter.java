package com.aqsa.rasmenu.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aqsa.rasmenu.R;
import com.aqsa.rasmenu.main_categories;
import com.aqsa.rasmenu.meals_category_list;
import com.aqsa.rasmenu.models.Addition;
import com.aqsa.rasmenu.models.AdditionArray;
import com.aqsa.rasmenu.models.Drink;
import com.aqsa.rasmenu.models.Generic;

import java.util.ArrayList;

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<Addition> data;

    public AdditionAdapter(Activity activity, ArrayList<Addition> data) {
        this.activity = activity;
        this.data = data;
    }

    public AdditionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(activity).inflate(R.layout.activity_sold_item_view, null, false);
        return new MyViewHolder(root);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.description.setText(data.get(position).getDiscription());
        holder.price.setText(""+data.get(position).getPrice());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                data.remove(position);
                Toast.makeText(activity, "Done ... Refrishing", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(activity,main_categories.class);
                activity.startActivity(i);
            }
        });
        holder.img.setImageResource(data.get(position).getImg());
        holder.quantity.setText(""+data.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,description,price,quantity;
        public ImageView img;
        public Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            description = itemView.findViewById(R.id.Discription);
            price = itemView.findViewById(R.id.price);
            img=itemView.findViewById(R.id.img0);
            btn=itemView.findViewById(R.id.btn);
            quantity=itemView.findViewById(R.id.quantity);
        }
    }
}