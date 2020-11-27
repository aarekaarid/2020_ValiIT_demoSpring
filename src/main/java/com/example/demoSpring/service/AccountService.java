package com.example.demoSpring.service;

import com.example.demoSpring.controller.Account;
import com.example.demoSpring.controller.Account2;
import com.example.demoSpring.exception.ApplicationException;
import com.example.demoSpring.repo2.Customer;
import com.example.demoSpring.repository.AccountRepository;
import com.example.demoSpring.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private HistoryRepository historyRepository;

    // CREATE ACCOUNT @PostMapping("account")
    public void createAccount(Account account){
        accountRepository.createAccount(account);
//        historyRepository.updateHistory(accountnr, BigDecimal.ZERO, BigDecimal.ZERO, "CREATE_ACCOUNT");
    }

    //QUERY to DATABASE @GetMapping("account/{id}")
    public BigDecimal showBalance(int id) {
        return accountRepository.showBalance(id);   //NB! return current database balance by id and it is BigDecimal
    }

    // DEPOSIT MONEY to DATABASE USING POSTMAN
    public void depositMoney(String accountnr, BigDecimal amount) {
        if (accountRepository.getAccounts().contains(accountnr)){

            BigDecimal newBalance = accountRepository.getBalance(accountnr).add(amount);
            accountRepository.saveBalance(accountnr, newBalance);
            //WRITING THE DEPOSIT ACTION INTO HISTORY TABLE IN DATABASE
            historyRepository.updateHistory(accountnr, amount, newBalance, "DEPOSIT");
        } else {
            throw new ApplicationException("Account does not exit.");
        }
    }

    // WITHDRAW MONEY FROM DATABASE ACCOUNT | võtab kontolt raha (vähendab kontol olevat rahasummat)
    public void withdrawMoney(String accountnr, BigDecimal amount) {
        if (accountRepository.getBalance(accountnr).compareTo(amount) < 0){
            throw new ApplicationException("Not enough $$$");
        } else {
            BigDecimal newBalance = accountRepository.getBalance(accountnr).subtract(amount);
            accountRepository.saveBalance(accountnr, newBalance);
            //WRITING THE WITHDRAW ACTION INTO HISTORY TABLE IN DATABASE
            historyRepository.updateHistory(accountnr, amount.multiply(BigDecimal.valueOf(-1)), newBalance, "WITHDRAW");
        }
    }

    // TRANSFER MONEY BETWEEN DATABASE ACCOUNTS USING POSTMAN
    public void transferMoney(String accountnr1, String accountnr2, BigDecimal amount) {
        BigDecimal newBalance1 = accountRepository.getBalance(accountnr1).subtract(amount);
        BigDecimal newBalance2 = accountRepository.getBalance(accountnr2).add(amount);
        accountRepository.saveBalance(accountnr1, newBalance1);
        accountRepository.saveBalance(accountnr2, newBalance2);

        //WRITING THE TRANSFERE_FROM ACTION INTO HISTORY TABLE IN DATABASE
        historyRepository.updateHistory(accountnr1, amount.multiply(BigDecimal.valueOf(-1)), newBalance1, "TRANSFER_FROM");
        historyRepository.updateHistory(accountnr2, amount, newBalance2, "TRANSFER_TO");

    }

    //QUERY FOR MULTIPLE COLUMNS with AccountRowMapper 2020-11-11
    public List<Account> selectManyRows() {
        return accountRepository.selectManyRows();  //comes to Postman
    }

    // QUERY FOR ONE SPECIFIC ACCOUNT FROM DATABASE
    public Account selectRow(int id){
        return accountRepository.selectRow(id);
    }

    // UPDATE ADDRESS in DATABASE USING POSTMAN
    public void updateAddress(String name, String newaddress){
        accountRepository.updateAddress(name, newaddress);
    }

}
