package com.revature;

public class Account {
    private double balance = 0;
    private int accountNumber;
    private int userId;
    private String status;

    public Account(int userId){
        this.userId = userId;
        this.status = "pending";
    }

    public Account(int balance, int accountNumber, int userId, String status) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}
