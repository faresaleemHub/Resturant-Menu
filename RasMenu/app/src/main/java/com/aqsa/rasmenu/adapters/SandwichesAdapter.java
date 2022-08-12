package com.aqsa.rasmenu.adapters;

import android.app.Activity;
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
import com.aqsa.rasmenu.models.sandwich;

import java.util.ArrayList;

public class SandwichesAdapter extends RecyclerView.Adapter<SandwichesAdapter.MyViewHolder> {
    private Activity activity;
    private ArrayList<sandwich> data;


    public SandwichesAdapter(Activity activity, ArrayList<sandwich> data) {
        this.activity = activity;
        this.data = data;
    }

    @NonNull
    @Override
    public SandwichesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(activity).inflate(R.layout.activity_view_items, null, false);
        return new SandwichesAdapter.MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull SandwichesAdapter.MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.description.setText(data.get(position).getDiscription());
        holder.price.setText(""+data.get(position).getPrice());
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
        holder.img.setImageResource(data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,description,price;
        public ImageView img;
        public Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            description = itemView.findViewById(R.id.Discription);
            price = itemView.findViewById(R.id.price);
            btn=itemView.findViewById(R.id.add);
            img=itemView.findViewById(R.id.img);
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