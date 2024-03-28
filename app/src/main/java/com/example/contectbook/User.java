package com.example.contectbook;

public class User {
    int userid;
    String name;
    String number;

    public User(int userid, String name, String number) {
        this.userid = userid;
        this.name = name;
        this.number = number;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
