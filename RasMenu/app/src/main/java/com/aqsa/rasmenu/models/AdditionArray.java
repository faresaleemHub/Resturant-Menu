package com.aqsa.rasmenu.models;

import java.util.ArrayList;

public class AdditionArray {

    private static ArrayList<Addition> add=new ArrayList<>();

    public static void setData(Addition a){
        add.add(a);
    }

    public static void removeData(){ add.clear();}

    public static ArrayList<Addition> getData(){
        return add;
    }
    public static int getSize(){
        return add.size();
    }

    public static int getTotalPrice(){
        int sum=0;
        for(int i=0;i<add.size();i++){
            sum+=add.get(i).getPrice();
        }
        return sum;
    }

    public static int getTotalQuantity(){
        int sum=0;
        for(int i=0;i<add.size();i++)
            sum+=add.get(i).getQuantity();
        return sum;
    }
}
