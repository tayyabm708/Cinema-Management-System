package com.codewithTayyab;

import java.io.Serializable;

public class User extends Person implements Serializable {
    public User() {
    }

    public User(String fn, String ln) {
        super(fn,ln);
    }

    public User(User u) {
        super(u);
    }
}
