package com.aqsa.rasmenu.Join;

import java.util.ArrayList;

public class ArrayAccount {

    private static ArrayList<UserAccount> arr =new ArrayList<>();

    public static void setAccount(UserAccount a){
        arr.add(a);
    }
    public static ArrayList<UserAccount> getAccount(){ return arr; }
}
