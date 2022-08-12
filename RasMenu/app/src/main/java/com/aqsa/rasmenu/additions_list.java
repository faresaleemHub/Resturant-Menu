package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.aqsa.rasmenu.adapters.AdditionAdapter;
import com.aqsa.rasmenu.models.Addition;
import com.aqsa.rasmenu.models.AdditionArray;
import com.aqsa.rasmenu.models.Drink;
import com.aqsa.rasmenu.models.Generic;

import java.util.ArrayList;

public class additions_list extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additions_list);

        final RecyclerView rv=findViewById(R.id.rvAdd);
        RecyclerView.LayoutManager lmg=new LinearLayoutManager(this);
        rv.setLayoutManager(lmg);

        AdditionAdapter mdp = new AdditionAdapter(this,AdditionArray.getData());
        mdp.notifyDataSetChanged();
        rv.setAdapter(mdp);
        TextView totalPrice=findViewById(R.id.totalPrice);
        TextView totalQuantity=findViewById(R.id.totalQuantity);

        totalPrice.setText(""+AdditionArray.getTotalPrice());
        totalQuantity.setText(""+AdditionArray.getTotalQuantity());
    }
}