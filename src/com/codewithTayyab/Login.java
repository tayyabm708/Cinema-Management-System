package com.codewithTayyab;

import java.io.Serializable;

public class Login implements Serializable {
    public Login() {
    }

    public boolean LoggingIn(Object o,String u ,String p){
        String resource =  o.getClass().getSimpleName();
        if(o instanceof Administrator)
        {
            Administrator a = (Administrator)o;
            Filing fi = new Filing();
            if(fi.readFromFile(a,u,p))
                return true;
        }

        else if(o instanceof FoodSeller)
        {
            FoodSeller f = (FoodSeller) o;
            Filing fi = new Filing();
            if(fi.readFromFile(f,u,p))
                return true;
        }

        else if(o instanceof TicketSeller){
            TicketSeller t = (TicketSeller)o;
            Filing fi = new Filing();
            if(fi.readFromFile(t,u,p))
                return true;
        }
        return false;
    }
}
