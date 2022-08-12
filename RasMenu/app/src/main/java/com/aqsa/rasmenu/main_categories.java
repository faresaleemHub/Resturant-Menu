package com.aqsa.rasmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aqsa.rasmenu.models.AdditionArray;
import com.aqsa.rasmenu.models.Generic;

import java.util.ArrayList;

public class main_categories extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_categories);

        findViewById(R.id.l_meals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), meals_category_list.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.l_sandwiches).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), sandwichs_category_list.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.l_drinks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), drinks_category_list.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.l_entrees).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), entrees_category_list.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.l_purchas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), additions_list.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        AdditionArray.removeData();

    }
}