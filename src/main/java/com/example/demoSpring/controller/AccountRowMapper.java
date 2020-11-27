package com.example.demoSpring.controller;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {     //i is row index
        Account account = new Account();
        account.setAccountnr(resultSet.getString("accountnr"));
        account.setBalance(resultSet.getBigDecimal("balance"));
        account.setName(resultSet.getString("name"));
        account.setAddress(resultSet.getString("address"));
        return account;
    }
}
