package com.aqsa.rasmenu.adapters;

import android.app.Activity;
import android.content.Context;
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
import com.aqsa.rasmenu.models.Addition;
import com.aqsa.rasmenu.models.AdditionArray;
import com.aqsa.rasmenu.models.Generic;
import com.aqsa.rasmenu.models.Meal;

import java.util.ArrayList;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MyViewHolder> {
    private Activity activity;
    private ArrayList<Meal> data;

    public MealsAdapter(Activity activity, ArrayList<Meal> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public MealsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(activity).inflate(R.layout.activity_view_items, null, false);
        return new MealsAdapter.MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.description.setText(data.get(position).getDiscription());
        holder.price.setText(""+data.get(position).getPrice());
        holder.img.setImageResource(data.get(position).getImg());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Addition add=new Addition (data.get(position).getImg(),
                        data.get(position).getName(),
                        data.get(position).getDiscription(),
                        data.get(position).getPrice(),data.get(position).getMainPrice(),data.get(position).getQuantity());

                int mainPrice=data.get(position).getMainPrice();

                if (ifExist(add)) {
                    int quantity=AdditionArray.getData().get(Index(add)).getQuantity();
                    quantity++;
                    AdditionArray.getData().get(Index(add)).setQuantity(quantity);

                    int price=AdditionArray.getData().get(Index(add)).getPrice();
                    AdditionArray.getData().get(Index(add)).setPrice(price+mainPrice);
                    Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show();
                    return;
                }
                AdditionArray.setData(add);
                Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;
        public ImageView img;
        public Button btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            description = itemView.findViewById(R.id.Discription);
            price = itemView.findViewById(R.id.price);
            btn = itemView.findViewById(R.id.add);
            img = itemView.findViewById(R.id.img);
        }
    }

    public boolean ifExist(Addition a) {
        for (int i = 0; i < AdditionArray.getSize(); i++) {
            if (AdditionArray.getData().get(i).getName().equals(a.getName())) {
                return true;
            }
        }
        return false;
    }

    public int Index(Addition a){
        for(int i=0;i<AdditionArray.getSize();i++)
            if(AdditionArray.getData().get(i).getName().equals(a.getName()))
                return i;
        return 0;
    }
}