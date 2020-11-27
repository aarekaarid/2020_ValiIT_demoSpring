package com.example.demoSpring.controller;

import java.math.BigDecimal;

public class Account {
    private String accountnr;
    private BigDecimal balance;     //NB! with money use BigDecimal (when division, use always Rounding mode)
    private String name;
    private String address;

    // for hard way (see BankController.java)
    public Account(String accountnr) {
        this.accountnr = accountnr;
        this.balance = BigDecimal.ZERO;
    }

    // new constructor with no input (for AccountRowMapper)
    public Account() {
    }

    public String getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
}
