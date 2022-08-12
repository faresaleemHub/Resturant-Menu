package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aqsa.rasmenu.adapters.SandwichesAdapter;
import com.aqsa.rasmenu.models.sandwich;

import java.util.ArrayList;

public class sandwichs_category_list extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwichs_category_list);

        final RecyclerView rv = findViewById(R.id.rvSandwich);
        RecyclerView.LayoutManager lmg = new LinearLayoutManager(this);
        rv.setLayoutManager(lmg);

        ArrayList<sandwich> data = getMealData();
        SandwichesAdapter mdp = new SandwichesAdapter(this, data);
        rv.setAdapter(mdp);
    }

    private ArrayList getMealData() {
        ArrayList<sandwich> data = new ArrayList<>();

        sandwich m1 = new sandwich(
                R.drawable.hampurgar,
                "Burgar", "Meat, cheese," +
                "lettuce, onions, tomatoes, pickles," +
                "mayonnaise, ketchup, potatoes.", 15,15,1);

        sandwich m2 = new sandwich(
                R.drawable.taylandy,
                "Taylandy", "Meat, salad, potatoes, bread", 15,15,1);

        sandwich m3 = new sandwich(
                R.drawable.shawarma,
                "Shawarma", "Meat, tahini, hot sauce, muggal potatoes", 10,10,1);

        sandwich m4 = new sandwich(
                R.drawable.pizza,
                "Pizza", "Oil, olives, cheese, tomatoes, peppers, black olives, sauce, basil",
                15,15,1);

        data.add(m1);
        data.add(m2);
        data.add(m3);
        data.add(m4);

        return data;
    }
}