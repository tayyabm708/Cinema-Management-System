package com.codewithTayyab;

import java.io.Serializable;

public class FoodSeller extends Employee implements Serializable {
    public FoodSeller() {
        super();
    }

    public FoodSeller(String fn, String ln,  Date d1, Date d2, Address a,String u , String p) {
        super(fn, ln, d1, d2, a,u,p);
    }

    public FoodSeller(FoodSeller fs) {
        super(fs);
    }
}
