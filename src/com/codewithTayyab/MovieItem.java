package com.codewithTayyab;

import java.io.Serial;
import java.io.Serializable;

public class MovieItem implements Serializable {
    private String name;
    private String genre;
    private double standardTicket;
    private double executiveTicket;
    private float  rating;
    private String path;

    public MovieItem() {
    }

    public MovieItem(String name, String genre, double standardTicket, double executiveTicket, float rating, String path) {
        this.name = name;
        this.genre = genre;
        this.standardTicket = standardTicket;
        this.executiveTicket = executiveTicket;
        this.rating = rating;
        this.path = path;
    }

    public MovieItem(MovieItem m) {
        this.name = m.name;
        this.genre = m.genre;
        this.standardTicket = m.standardTicket;
        this.executiveTicket = m.executiveTicket;
        this.rating = m.rating;
        this.path = m.path;

    }

    @Override
    public String toString() {
        return " Name "+name+" Genre "+genre+" Price Of Standard Ticket "+standardTicket+" Price Of Executive Ticket " +executiveTicket+" Ratings "+rating+" Pathname " + path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getStandardTicket() {
        return standardTicket;
    }

    public void setStandardTicket(double standardTicket) {
        this.standardTicket = standardTicket;
    }

    public double getExecutiveTicket() {
        return executiveTicket;
    }

    public void setExecutiveTicket(double executiveTicket) {
        this.executiveTicket = executiveTicket;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
