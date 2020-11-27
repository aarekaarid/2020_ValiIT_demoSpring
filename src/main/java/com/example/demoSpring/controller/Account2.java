package com.example.demoSpring.controller;

public class Account2 {
    String name;
    String address;
    String accountnr;

    public Account2(String name, String address, String accountnr) {
        this.name = name;
        this.address = address;
        this.accountnr = accountnr;
    }

    public Account2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }
}
