package com.aqsa.rasmenu.Join;

import com.aqsa.rasmenu.models.Addition;

import java.util.ArrayList;

public class UserAccount {

    String username,fname,Date,phone,gender,location,passowrd;
    boolean remember=false;

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public UserAccount(String fname, String username, String Date, String phone, String gender, String location, String passowrd) {
        this.username = username;
        this.fname = fname;
        this.Date=Date;
        this.phone = phone;
        this.gender = gender;
        this.location = location;
        this.passowrd = passowrd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return location;
    }

    public void setCountry(String country) {
        this.location = location;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd1) {
        this.passowrd = passowrd;
    }

}
