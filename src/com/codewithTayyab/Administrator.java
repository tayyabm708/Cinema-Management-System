package com.codewithTayyab;

import java.io.Serializable;

public class Administrator extends Person implements Serializable {
    private String Username;
    private String Password;

    public Administrator() {
    }

    public Administrator(String fn, String ln,String u, String p) {
        super(fn, ln);
        this.Username=u;
        this.Password=p;
    }

    public Administrator(Administrator a) {
        super(a);
        this.Username=a.Username;
        this.Password=a.Password;
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
