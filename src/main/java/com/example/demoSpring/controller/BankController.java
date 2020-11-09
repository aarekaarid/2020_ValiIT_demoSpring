package com.example.demoSpring.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    //creating empty Map (key, value pair) kind of dictionary
//    private Map<String, BigDecimal> accountsBalanceTable = new HashMap<>();   //for easy way
    private Map<String, Account> accounts = new HashMap<>();    //for hard way

    // createAccount (accountNr)
    @PostMapping("account")
    public void  createAccount(@RequestBody String accountNr) {
        //one way
//        accountsBalanceTable.put(accountNr, BigDecimal.ZERO);

        //other way
        accounts.put(accountNr, new Account(accountNr));

    }
    // shows all the accounts
    @GetMapping("account")
    public Map<String, Account> accountsTable(){
        return accounts;
    }
    // puts money to specified account
    @PutMapping("account/deposit")
    public Map<String, Account> depositMoney(@RequestParam("accountNr") String accountNr,
                                             @RequestParam("amount") BigDecimal amount){
//        //variant1
//        BigDecimal oldValue = accountsBalanceTable.get(accountNr);
//        BigDecimal newValue = oldValue.add(amount);
//        accountsBalanceTable.put(accountNr, newValue);
//
//        //variant2
        Account account = accounts.get(accountNr);  //creates variable and takes accountNr from Hashmap
        BigDecimal oldValue = account.getBalance(); //saves old balance from Getter
        BigDecimal newValue = oldValue.add(amount); //adds newValue to oldValue using .add
        account.setBalance(newValue);   //setting newValue to balance using Setter
        accounts.put(accountNr, account);   //puts account into the HashMap

        return accounts;
    }
    // getAccount(String accountNr) | tagasta kui palju raha on vastaval kontol
    @GetMapping("account/{accountNr}")
    public BigDecimal showBalance(@PathVariable("accountNr") String accountNr){
        Account account = accounts.get(accountNr);  //creates variable and takes accountNr from Hashmap
        BigDecimal balance = account.getBalance();  //saves current balance from Getter
        return balance;
    }
    // withdrawMoney(String accountNr, amount) | võtab kontolt raha (vähendab kontol olevat rahasummat)
    @PutMapping("account/withdraw")
    public Map<String, Account> withdrawMoney(@RequestParam("accountNr") String accountNr,
                                              @RequestParam("amount") BigDecimal amount){
        Account account = accounts.get(accountNr);  //creates variable and takes accountNr from Hashmap
        BigDecimal oldValue = account.getBalance(); //saves old balance from Getter
        BigDecimal newValue = oldValue.subtract(amount); //subtracts newValue from oldValue using .subtract
        account.setBalance(newValue);   //setting newValue to balance using Setter
        accounts.put(accountNr, account);   //puts account into the HashMap

        return accounts;    //returns Map (key/value pairs)
    }
    // transferMoney(String account1, String account2, amount) | kanna raha esimeselt kontolt teisele kontole
    @PutMapping("account/transfer")
    public Map<String, Account> transferMoney(@RequestParam("accountNr1") String accountNr1,
                                              @RequestParam("accountNr2") String accountNr2,
                                              @RequestParam("amount") BigDecimal amount){
        //withdraw amount from account1
        Account account1 = accounts.get(accountNr1);
        BigDecimal oldValue1 = account1.getBalance();
        BigDecimal newValue1 = oldValue1.subtract(amount);
        account1.setBalance(newValue1);
        accounts.put(accountNr1, account1);

        //deposit amount to account2
        Account account2 = accounts.get(accountNr2);
        BigDecimal oldValue2 = account2.getBalance();
        BigDecimal newValue2 = oldValue2.add(amount);
        account2.setBalance(newValue2);
        accounts.put(accountNr2, account2);

        return accounts;
    }





}
