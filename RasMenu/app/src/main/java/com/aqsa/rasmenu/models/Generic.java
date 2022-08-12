package com.aqsa.rasmenu.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Generic {

    protected String name,discription;
    protected int img,quantity,price,mainPrice;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMainPrice() {
        return mainPrice;
    }

    public void setMainPrice(int mainPrice) {
        this.mainPrice = mainPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

