package com.codewithTayyab;

import java.io.Serializable;

public class Register implements Serializable {
    public Register() {
    }

    public void Registration(Object o){
        String resource=o.getClass().getSimpleName();

        if(o instanceof Administrator)
        {
            Administrator a = (Administrator)o;
            Filing fi = new Filing();
            int i = fi.NumberOf(a);
            if(i == 0){
                fi.writeToFile(a);
            }
            else
                System.out.println("Administrator already Exists");
        }

        else if(o instanceof FoodSeller)
        {
            FoodSeller f = (FoodSeller) o;
            Filing fi = new Filing();
            int i = fi.NumberOf(f);
            if(i<3) {
                fi.writeToFile(f);
            }
            else{
                System.out.println("Maximum Food Sellers Exist");
            }
        }

        else if(o instanceof TicketSeller){
            TicketSeller t = (TicketSeller)o;
            Filing fi = new Filing();
            int i = fi.NumberOf(t);
            if(i<3) {
                fi.writeToFile(t);
            }
            else
                System.out.println("Maximum Ticket Sellers Exist");
        }
    }
}
