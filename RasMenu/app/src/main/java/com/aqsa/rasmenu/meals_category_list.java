package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aqsa.rasmenu.adapters.MealsAdapter;
import com.aqsa.rasmenu.adapters.SandwichesAdapter;
import com.aqsa.rasmenu.models.Generic;
import com.aqsa.rasmenu.models.Meal;
import com.aqsa.rasmenu.models.sandwich;

import java.util.ArrayList;

public class meals_category_list extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_category_list);

        final RecyclerView rv = findViewById(R.id.rvMeals);
        RecyclerView.LayoutManager lmg = new LinearLayoutManager(this);
        rv.setLayoutManager(lmg);

        ArrayList<Meal> data = getMealData();
        MealsAdapter mdp = new MealsAdapter(this, data);
        rv.setAdapter(mdp);
    }
    private ArrayList getMealData(){
        ArrayList <Meal> data=new ArrayList<>();

        Meal m1=new Meal(
                R.drawable.grilledchicken,
                "Grilled chicken",
                "Chicken breast, onion, spices, pepper, vegetable salad, mashed potatoes",
                20,20,1);
        Meal m2=new Meal(
                R.drawable.shishtawook,
                "grilled wings",
                "chicken wings, vinegar, spices, honey, french fries",
                15,15,1);
        Meal m3=new Meal(
                R.drawable.kabab,
                "kebab",
                "Veal meat, grilled onion, pepper, tomato, tahini salad",
                20,20,1);
        Meal m4=new Meal(
                R.drawable.chickenstuffed,
                "Chicken stuffed",
                "Chicken, seasoned rice, onion, garlicd",
                30,30,1);

        data.add(m1);
        data.add(m4);
        data.add(m3);
        data.add(m2);
        return data;
    }
}