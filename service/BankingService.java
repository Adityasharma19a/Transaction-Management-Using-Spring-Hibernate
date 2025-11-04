package com.example.banking.service;

import com.example.banking.dao.AccountDAO;
import com.example.banking.dao.TransactionDAO;
import com.example.banking.entity.Account;
import com.example.banking.entity.TransactionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account from = accountDAO.getAccountById(fromId);
        Account to = accountDAO.getAccountById(toId);

        if (from == null || to == null) {
            throw new RuntimeException("Invalid account(s).");
        }

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in sender's account.");
        }

        // Deduct and add money
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountDAO.updateAccount(from);
        accountDAO.updateAccount(to);

        // Record transaction
        TransactionRecord record = new TransactionRecord(fromId, toId, amount);
        transactionDAO.saveTransaction(record);

        System.out.println("✅ Transaction Successful: " + record);
    }
}
