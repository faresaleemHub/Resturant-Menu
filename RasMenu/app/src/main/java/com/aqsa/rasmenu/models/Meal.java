package com.aqsa.rasmenu.models;

public class Meal extends Generic{

    public Meal(int img,String name,String discription , int price,int mainPrice,int quantity){
        this.name=name;
        this.discription=discription;
        this.price=price;
        this.mainPrice=mainPrice;
        this.img=img;
        this.quantity=quantity;
    }
}
