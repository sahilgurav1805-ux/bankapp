//package com.sahil.bankapp.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "transactions")
//public class Transaction {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private long accountNumber;
//
//    private String type; // DEPOSIT or WITHDRAW
//
//    private double amount;
//
//    private double balance;
//
//    private LocalDateTime dateTime;
//
//    public Transaction() {
//        this.dateTime = LocalDateTime.now();
//    }
//
//    public Transaction(long accountNumber, String type, double amount, double balance) {
//        this.accountNumber = accountNumber;
//        this.type = type;
//        this.amount = amount;
//        this.balance = balance;
//        this.dateTime = LocalDateTime.now();
//    }
//
//    // getters and setters
//    public int getId() { return id; }
//
//    public long getAccountNumber() { return accountNumber; }
//    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }
//
//    public String getType() { return type; }
//    public void setType(String type) { this.type = type; }
//
//    public double getAmount() { return amount; }
//    public void setAmount(double amount) { this.amount = amount; }
//
//    public double getBalance() { return balance; }
//    public void setBalance(double balance) { this.balance = balance; }
//
//    public LocalDateTime getDateTime() { return dateTime; }
//    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
//}