package com.codewithTayyab;

import java.io.Serializable;

public class TicketSeller extends Employee implements Serializable {
    public TicketSeller() {
        super();
    }

    public TicketSeller(String fn, String ln,Date d1, Date d2, Address a,String u , String p ) {
        super(fn, ln, d1, d2, a, u, p);
    }

    public TicketSeller(TicketSeller ts) {
        super(ts);
    }
}
