package com.example.banking.dao;

import com.example.banking.entity.TransactionRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTransaction(TransactionRecord transaction) {
        sessionFactory.getCurrentSession().persist(transaction);
    }
}
