package com.codewithTayyab;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(){
        this.day=0;
        this.month=0;
        this.year=0;
    }

    public Date(int d,int m ,int y){
        if(d>=1 && d<=31 && m >=1 && m<=12 && y>=1 && y<=2020) {
            this.day=d;
            this.month=m;
            this.year=y;
        }
    }

    public Date(Date d){
        if(d.day>=1 && d.day<=31 && d.month >=1 && d.month<=12 && d.year>=1 && d.year<=2020) {
            this.day=d.day;
            this.month=d.month;
            this.year=d.year;
        }
    }

    public String toString(){
        return this.day+"/"+this.month+"/"+this.year;
    }

    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }

    public int getMonth() { return month; }

    public void setMonth(int month) { this.month = month;}

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }
}
