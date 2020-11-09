package com.example.demoSpring.controller;

import java.math.BigDecimal;

public class Account {
    private String accountNr;
    private BigDecimal balance;     //NB! with money use BigDecimal (when division, use always Rounding mode)

    // for hard way (see BankController.java)
    public Account(String accountNr) {
        this.accountNr = accountNr;
        this.balance = BigDecimal.ZERO;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
