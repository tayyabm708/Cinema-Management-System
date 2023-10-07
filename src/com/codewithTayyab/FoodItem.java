package com.codewithTayyab;

import java.io.Serializable;

public class FoodItem implements Serializable {
    private String name;
    private double sPrice;
    private double mPrice;
    private double lPrice;
    private String pathname;

    public FoodItem(){

    }

    public FoodItem(String name, double sPrice, double mPrice , double lPrice , String path) {
        this.name = name;
        this.sPrice = sPrice;
        this.mPrice = mPrice;
        this.lPrice = lPrice;
        this.pathname=path;
    }

    public FoodItem(FoodItem f){
        this.name=f.name;
        this .sPrice=f.sPrice;
        this .mPrice=f.mPrice;
        this .lPrice=f.lPrice;
        this.pathname=f.pathname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getsPrice() {
        return sPrice;
    }

    public void setsPrice(double sPrice) {
        this.sPrice = sPrice;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public double getlPrice() {
        return lPrice;
    }

    public void setlPrice(double lPrice) {
        this.lPrice = lPrice;
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public String toString() {
        return " Name "+name+" Price of small "+sPrice+" Price of Medium "+mPrice+" Price of Large " +lPrice+ " Pathname " + pathname;
    }
}
