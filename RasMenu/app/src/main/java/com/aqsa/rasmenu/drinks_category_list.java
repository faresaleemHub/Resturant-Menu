package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aqsa.rasmenu.adapters.DrinksAdapter;
import com.aqsa.rasmenu.models.Drink;

import java.util.ArrayList;

public class drinks_category_list extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_category_list);

        final RecyclerView rv=findViewById(R.id.rvDrinks);
        RecyclerView.LayoutManager lmg=new LinearLayoutManager(this);
        rv.setLayoutManager(lmg);

        ArrayList<Drink> data = getMealData();
        DrinksAdapter mdp = new DrinksAdapter(this, data);
        rv.setAdapter(mdp);
    }
    private ArrayList getMealData(){
        ArrayList <Drink> data=new ArrayList<>();
        Drink d1=new Drink(
                R.drawable.cappuccino,
                "cappuccino","Espresso, milk foam, milk, coffee",5,5,1);
        Drink d2=new Drink(
                R.drawable.coctale,
                "cocktail","Apple, banana, mango, strawberry",4,4,1);
        Drink d3=new Drink(
                R.drawable.milkshake,"milk shake",
                "Milk, chocolate",4,4,1);
        Drink d4=new Drink(
                R.drawable.cocacola,"Coca Cola",
                "Sugar, caffeine, natural flavors, caramel color, phosphoric acid",
                3,3,1);


        data.add(d1);
        data.add(d2);
        data.add(d3);
        data.add(d4);

        return data;
    }
}