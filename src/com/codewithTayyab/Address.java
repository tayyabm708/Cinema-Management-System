package com.codewithTayyab;

import java.io.Serializable;

public class Address implements Serializable {
    private String home;
    private int street;
    private String city;


    public Address(){
        this.home=null;
        this.street=0;
        this.city=null;
    }

    public Address(String h, int s,String c){
        if(h!=null&& s!=0&& c!=null) {
            this.home = h;
            this.street = s;
            this.city = c;
        }
    }

    public Address(Address pa) {
        if(pa.home!=null&& pa.street!=0 &&pa.city!=null) {
            this.home = pa.home;
            this.street = pa.street;
            this.city = pa.city;
        }
    }

    @Override
    public String  toString(){
        return  this.home+" - "+this.street+" - "+this.city;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
