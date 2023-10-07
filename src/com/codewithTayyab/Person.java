package com.codewithTayyab;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String LastName;

    public Person() {
    }

    public Person(String fn, String ln) {
        this.firstName = fn;
        this.LastName = ln;
    }

    public Person(Person p) {
        this.firstName = p.firstName;
        this.LastName = p.LastName;
    }

    @Override
    public String  toString() {
        return  "First name is : " + this.firstName + " Last name is : " + this.LastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
