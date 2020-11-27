package com.example.demoSpring.controller;

import com.example.demoSpring.repository.AccountRepository;
import com.example.demoSpring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController {
    //creating empty Map (key, value pair) kind of dictionary
    //private Map<String, BigDecimal> accountsBalanceTable = new HashMap<>();   //for easy way
    //private final Map<String, Account> accounts = new HashMap<>();    //for hard way
    // this is for connecting to database
    @Autowired
    private AccountService accountService;
    //REMEBER TO AUTOWIRE EVERYTIME!!!!
    @Autowired
    private AccountRepository accountRepository;

    // CREATE ACCOUNT to DATABASE USING POSTMAN
    @CrossOrigin
    @PostMapping("account")
    public List<Account> createAccount(@RequestBody Account account) {
        System.out.println(account);
        accountService.createAccount(account);
        return accountService.selectManyRows();

        //that's how we write to SQL db
//        String sql = "INSERT INTO customer (name, address, accountnr) VALUES (:x1, :x2, :x3)";
//        //define the values
//        Map<String, String> paramMap = new HashMap<>();
//        paramMap.put("x1", requestName);
//        paramMap.put("x2", requestAddress);
//        paramMap.put("x3", accountnr);
//        namedParameterJdbcTemplate.update(sql, paramMap);

        //one way
//        accountsBalanceTable.put(accountNr, BigDecimal.ZERO);

        //other way
//        accounts.put(accountNr, new Account(accountNr));

    }
    // shows all the accounts
//    @GetMapping("account")
//    public Map<String, Account> accountsTable(){
////        String sql = "SELECT * FROM customer";
////        Map<String, Object> paraMap = new HashMap<>();
////        BigDecimal dbBalance = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
//        return accounts;
//    }

    // ALL ACCOUNTS from DATABASE??????
//    @GetMapping("account")
//    public Map<String, Object> accountsTable(){
//        String sql = "SELECT * FROM customer";
//        Map<String, Object> paramMap = new HashMap<>();
//        Map<String, Object> db = namedParameterJdbcTemplate.queryForObject(sql, paramMap);
//        return db;
//    }


    // puts money to specified account
//    @PutMapping("account/deposit")
//    public Map<String, Account> depositMoney(@RequestParam("accountnr") String accountnr,
//                                             @RequestParam("amount") BigDecimal amount){
////        //variant1
////        BigDecimal oldValue = accountsBalanceTable.get(accountnr);
////        BigDecimal newValue = oldValue.add(amount);
////        accountsBalanceTable.put(accountnr, newValue);
////
////        //variant2
//        Account account = accounts.get(accountnr);  //creates variable and takes accountnr from Hashmap
//        BigDecimal oldValue = account.getBalance(); //saves old balance from Getter
//        BigDecimal newValue = oldValue.add(amount); //adds newValue to oldValue using .add
//        account.setBalance(newValue);   //setting newValue to balance using Setter
//        accounts.put(accountnr, account);   //puts account into the HashMap
//
//        return accounts;
//    }

    // QUERY to DATABASE USING POSTMAN | tagasta kui palju raha on vastaval kontol
    @CrossOrigin
    @GetMapping("account/{id}")
    public BigDecimal showBalance(@PathVariable("id") int id) {

        return accountService.showBalance(id);
    }

    // DEPOSIT MONEY to DATABASE USING POSTMAN
    @CrossOrigin
    @PutMapping("account/deposit")
    public BigDecimal depositMoney(@RequestParam("accountnr") String accountnr,
                             @RequestParam("amount") BigDecimal amount) {
        accountService.depositMoney(accountnr, amount);
        return accountRepository.getBalance(accountnr);
//        String sql = "SELECT balance FROM customer WHERE accountnr = :accountnr"; //SQL code syntax
//        Map<String, Object> paramMap = new HashMap<>();     //variable paraMap decrearing
//        paramMap.put("accountnr", accountnr);   // initializing paraMap
//        BigDecimal dbBalance = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);  //
//        BigDecimal newBalance = dbBalance.add(amount);
//
//        String sql1 = "UPDATE customer SET balance = :balance WHERE accountnr = :accountnr";
//        paramMap.put("balance", newBalance);
////        paramMap.put("accountnr", accountnr);     //not needed cause already existing in previous block???
//        namedParameterJdbcTemplate.update(sql1, paramMap);
    }


    // VERSION WITHOUT DATABASE
    // getAccount(String accountNr) | tagasta kui palju raha on vastaval kontol
//    @GetMapping("account/{accountNr}")
//    public BigDecimal showBalance(@PathVariable("accountNr") String accountNr){
//
//        Account account = accounts.get(accountNr);  //creates variable and takes accountNr from Hashmap
//        BigDecimal balance = account.getBalance();  //saves current balance from Getter
//        return balance;
//    }

    // WITHDRAW MONEY FROM DATABASE ACCOUNT | võtab kontolt raha (vähendab kontol olevat rahasummat)
    @CrossOrigin
    @PutMapping("account/withdraw")
    public BigDecimal withdrawMoney(@RequestParam("accountnr") String accountnr,
                              @RequestParam("amount") BigDecimal amount) {
        accountService.withdrawMoney(accountnr, amount);
        return accountRepository.getBalance(accountnr);

//        String sql = "SELECT balance FROM customer WHERE accountnr = :accountnr"; //SQL code syntax
//        Map<String, Object> paramMap = new HashMap<>();     //variable paraMap decrearing
//        paramMap.put("accountnr", accountnr);   // initializing paraMap
//        BigDecimal dbBalance = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);  //
//        BigDecimal newBalance = dbBalance.subtract(amount);
//
//        String sql1 = "UPDATE customer SET balance = :balance WHERE accountnr = :accountnr";
//        paramMap.put("balance", newBalance);
////        paramMap.put("accountnr", accountnr);     //not needed cause already existing in previous block???
//        namedParameterJdbcTemplate.update(sql1, paramMap);
    }



//    // withdrawMoney(String accountNr, amount) | võtab kontolt raha (vähendab kontol olevat rahasummat)
//    @PutMapping("account/withdraw")
//    public Map<String, Account> withdrawMoney(@RequestParam("accountnr") String accountnr,
//                                              @RequestParam("amount") BigDecimal amount) {
//        Account account = accounts.get(accountnr);  //creates variable and takes accountNr from Hashmap
//        BigDecimal oldValue = account.getBalance(); //saves old balance from Getter
//        BigDecimal newValue = oldValue.subtract(amount); //subtracts newValue from oldValue using .subtract
//        account.setBalance(newValue);   //setting newValue to balance using Setter
//        accounts.put(accountnr, account);   //puts account into the HashMap
//
//        return accounts;    //returns Map (key/value pairs)
//    }

    // TRANSFER MONEY BETWEEN DATABASE ACCOUNTS USING POSTMAN
    @CrossOrigin
    @PutMapping("account/transfer")
    public BigDecimal transferMoney(@RequestParam("accountnr1") String accountnr1,
                              @RequestParam("accountnr2") String accountnr2,
                              @RequestParam("amount") BigDecimal amount) {
        accountService.transferMoney(accountnr1, accountnr2, amount);
        return accountRepository.getBalance(accountnr1);
    }



    // transferMoney(String account1, String account2, amount) | kanna raha esimeselt kontolt teisele kontole
//    @PutMapping("account/transfer")
//    public Map<String, Account> transferMoney(@RequestParam("accountNr1") String accountNr1,
//                                              @RequestParam("accountNr2") String accountNr2,
//                                              @RequestParam("amount") BigDecimal amount) {
//        //withdraw amount from account1
//        Account account1 = accounts.get(accountNr1);
//        BigDecimal oldValue1 = account1.getBalance();
//        BigDecimal newValue1 = oldValue1.subtract(amount);
//        account1.setBalance(newValue1);
//        accounts.put(accountNr1, account1);
//
//        //deposit amount to account2
//        Account account2 = accounts.get(accountNr2);
//        BigDecimal oldValue2 = account2.getBalance();
//        BigDecimal newValue2 = oldValue2.add(amount);
//        account2.setBalance(newValue2);
//        accounts.put(accountNr2, account2);
//
//        return accounts;
//    }

    //QUERY FOR MULTIPLE COLUMNS with AccountRowMapper 2020-11-11
    @CrossOrigin
    @GetMapping("selectmany")
    public List<Account> selectManyRowsSample() {
        return accountService.selectManyRows();
    }

    // QUERY FOR ONE SPECIFIC ACCOUNT FROM DATABASE
    @CrossOrigin
    @GetMapping("selectrow/{id}")
    public Account selectRow(@PathVariable("id") int id){
         return accountService.selectRow(id);
    }

    // UPDATE ADDRESS in DATABASE USING POSTMAN
    @CrossOrigin
    @PutMapping("update/address")
    public void updateAddress(@RequestParam("name") String name,
                              @RequestParam("newaddress") String newaddress){
        accountService.updateAddress(name, newaddress);
    }




}
