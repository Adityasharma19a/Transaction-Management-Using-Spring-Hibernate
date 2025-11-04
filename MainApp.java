package com.example.banking;

import com.example.banking.config.AppConfig;
import com.example.banking.entity.Account;
import com.example.banking.service.BankingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        BankingService service = context.getBean(BankingService.class);

        // Create initial data (run once)
        /*
        SessionFactory sf = context.getBean(SessionFactory.class);
        Session session = sf.openSession();
        session.beginTransaction();
        session.persist(new Account("Alice", 1000));
        session.persist(new Account("Bob", 500));
        session.getTransaction().commit();
        session.close();
        */

        try {
            service.transferMoney(1, 2, 200);
        } catch (Exception e) {
            System.err.println("❌ Transaction Failed: " + e.getMessage());
        }

        context.close();
    }
}
