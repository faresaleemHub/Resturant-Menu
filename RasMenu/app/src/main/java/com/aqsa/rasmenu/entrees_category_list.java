package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aqsa.rasmenu.adapters.AdditionAdapter;
import com.aqsa.rasmenu.adapters.EntreesAdapter;
import com.aqsa.rasmenu.models.Entree;

import java.util.ArrayList;

public class entrees_category_list extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrees_category_list);

        final RecyclerView rv=findViewById(R.id.rvEnteers);
        RecyclerView.LayoutManager lmg=new LinearLayoutManager(this);
        rv.setLayoutManager(lmg);

        ArrayList<Entree> data = getMealData();
        EntreesAdapter mdp = new EntreesAdapter(this, data);
        rv.setAdapter(mdp);
    }
     ArrayList getMealData(){
        ArrayList <Entree> data=new ArrayList<>();

        Entree m1=new Entree(
                R.drawable.russiansalad,
                "Russian salad",
                "Potato, mayonnaise, peas, meat, carrots, eggs," +
                        " cucumbers, carrots, parsley, celery, pepper",
                5,5,1);
        Entree m2=new Entree(
                R.drawable.ttabouleh,
                "Tabouleh",
                "Mint, tomato, parsley, olive oil",
                5,5,1);
        Entree m3=new Entree(
                R.drawable.cornsalad,
                "Corn salad",
                "Corn, potato, parsley, yogurt, lemon, mayonnaise",
                5,5,1);

        data.add(m1);
        data.add(m2);
        data.add(m3);
        return data;
    }
}