package com.revature;

public class Transactions {
    private int transaction_id;
    private int account_id;
    private int account_id_to;
    private double amount;
    private String type;
    private String status;
    private String date;

    public Transactions(int transaction_id, int account_id, int account_id_to, double amount, String type, String status, String date) {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.account_id_to = account_id_to;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.date = date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getAccount_to_id() {
        return account_id_to;
    }

    public void setAccount_to_id(int account_id_to) {
        this.account_id_to = account_id_to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transaction_id=" + transaction_id +
                ", account_id=" + account_id +
                ", account_to_id=" + account_id_to +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
