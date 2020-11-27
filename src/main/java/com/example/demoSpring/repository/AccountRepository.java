package com.example.demoSpring.repository;

import com.example.demoSpring.controller.Account;
import com.example.demoSpring.controller.Account2;
import com.example.demoSpring.controller.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // CREATE ACCOUNT @PostMapping("account")
    public void createAccount(Account account){
        String sql = "INSERT INTO customer (name, address, accountnr, balance) VALUES (:x1, :x2, :x3, :x4)";
        //define the values
        Map<String, Object> paramMap = new HashMap<>(); //must be Object cause we have String:String pairs and String: Bigdecimal pair
        paramMap.put("x1", account.getName());
        paramMap.put("x2", account.getAddress());
        paramMap.put("x3", account.getAccountnr());
        paramMap.put("x4", BigDecimal.ZERO);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    //QUERY to DATABASE @GetMapping("account/{id}")
    public BigDecimal showBalance(int id) {
        String sql = "SELECT balance FROM customer WHERE id = :id";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("id", id);
        BigDecimal dbBalance = namedParameterJdbcTemplate.queryForObject(sql, paraMap, BigDecimal.class);
        return dbBalance;   //NB! return current database balance by id and it is BigDecimal
    }

    // GETTING BALANCE FROM DATABASE
    public BigDecimal getBalance(String accountnr) {

        String sql = "SELECT balance FROM customer WHERE accountnr = :accountnr"; //SQL code syntax
        Map<String, Object> paramMap = new HashMap<>();     //variable paraMap declearing
        paramMap.put("accountnr", accountnr);   // initializing paraMap
        BigDecimal dbBalance = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
        return dbBalance;
    }

    // OVERWRITING BALANCE IN DATABASE
    public void saveBalance(String accountnr, BigDecimal newBalance) {

        String sql1 = "UPDATE customer SET balance = :newBalance WHERE accountnr = :accountnr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("newBalance", newBalance);
        paramMap.put("accountnr", accountnr);     //not needed cause already existing in previous block???
        namedParameterJdbcTemplate.update(sql1, paramMap);
    }

    //QUERY FOR MULTIPLE COLUMNS with AccountRowMapper 2020-11-11
    public List<Account> selectManyRows() {
        String sql = "SELECT * FROM customer";
        Map paramMap = new HashMap();
        List<Account> result = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        // AccountRowMapper need to be created separately see AccountRowMapper.java
        return result;  //comes to Postman
    }

    // QUERY FOR ONE SPECIFIC ACCOUNT FROM DATABASE
    public Account selectRow(int id){
        String sql = "SELECT * FROM customer WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Account singlerow = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new AccountRowMapper());
        return singlerow;
    }

    // OVERWRITING ADDRESS IN DATABASE
    public void updateAddress(String name, String newaddress) {

        String sql = "UPDATE customer SET address = :newaddress WHERE name = :name";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("newaddress", newaddress);
        paramMap.put("name", name);     //not needed cause already existing in previous block???
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    //GETTING THE LIST OF ACCOUNTS USED FOR EXCEPTIONS
    public List getAccounts(){
        String sql = "SELECT accountnr FROM customer";
        Map paraMap = new HashMap();
        List<String> accounts = namedParameterJdbcTemplate.queryForList(sql, paraMap, String.class);
        return accounts;
    }


}
