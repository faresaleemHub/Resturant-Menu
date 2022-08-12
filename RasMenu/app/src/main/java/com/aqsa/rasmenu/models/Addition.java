package com.aqsa.rasmenu.models;

import java.util.ArrayList;

public class Addition extends Generic{

    public Addition(int img,String name,String discription , int price,int mainPrice,int quantity){
        this.name=name;
        this.discription=discription;
        this.price=price;
        this.img=img;
        this.mainPrice=mainPrice;
        this.quantity=quantity;
    }

    public Addition() {
    }
}