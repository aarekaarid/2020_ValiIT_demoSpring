package com.example.demoSpring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class HistoryRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //WRITING INTO DATABASE HISTORY TABLE
    public void updateHistory(String accountnr, BigDecimal amount, BigDecimal currentBalance, String action){
        String sql = "INSERT INTO history (accountnr, amount, balance, action) VALUES (:x1, :x2, :x3, :x4)";
        //define the values
        Map<String, Object> paramMap = new HashMap<>(); //must be Object cause we have String:String pairs and String: Bigdecimal pair
        paramMap.put("x1", accountnr);
        paramMap.put("x2", amount);
        paramMap.put("x3", currentBalance);
        paramMap.put("x4", action);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

}
