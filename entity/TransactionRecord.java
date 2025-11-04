package com.example.banking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_record")
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private LocalDateTime timestamp;

    public TransactionRecord() {}

    public TransactionRecord(int fromAccountId, int toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getFromAccountId() { return fromAccountId; }
    public int getToAccountId() { return toAccountId; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "TransactionRecord [id=" + id + ", from=" + fromAccountId + 
               ", to=" + toAccountId + ", amount=" + amount + ", time=" + timestamp + "]";
    }
}
