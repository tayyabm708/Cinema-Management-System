package com.codewithTayyab;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private Date birthDate;
    private Date hireDate;
    private Address address;
    private String Username;
    private String Password;

    public Employee(){
        super();
        this.birthDate = new Date();
        this.hireDate = new Date();
        this.address = new Address();
    }

    public Employee(String fn, String ln,Date d1,Date d2,Address a,String u, String p){
        super(fn,ln);
        this.birthDate = d1;
        this.hireDate = d2;
        this.address = a;
        this.Username=u;
        this.Password=p;

    }

    public Employee(Employee e){
        super(e);
        this.birthDate=new Date(e.birthDate);
        this.hireDate=new Date(e.hireDate);
        this.address = new Address(e.address);
        this.Username=e.Username;
        this.Password=e.Password;
    }

    @Override
    public String toString(){
        String s = super.toString() + "BirthDate is : "+birthDate.toString()+"HireDate is "+hireDate.toString()+"Address is "+address.toString();
        return s;
    }

    int  Experienced(){
        return 2020-hireDate.getYear();
    }

    public Date getBirthDate() { return new Date(birthDate); }

    public void setBirthDate(Date d) { this.birthDate = d; }

    public Date getHireDate() { return new Date(hireDate); }

    public void setHireDate(Date d) { this.hireDate = d; }

    public Address getAddress() {
        return new Address(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
