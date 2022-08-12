package com.aqsa.rasmenu.models;

public class sandwich extends Generic{

    public sandwich(int img,String name,String discription , int price,int mainPrice,int quantity){
        this.name=name;
        this.discription=discription;
        this.price=price;
        this.mainPrice=mainPrice;
        this.img=img;
        this.quantity=quantity;
    }
}