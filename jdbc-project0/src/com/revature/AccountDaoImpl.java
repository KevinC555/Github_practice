package com.revature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao, TransactionDao {

    Connection connection;

    public AccountDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public double checkBalance(int userId) throws SQLException {
        String sql = "select balance from account where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getDouble(1);
        }
        return 0;
    }

    @Override
    public void deposit(double amount, int userId) throws SQLException {
        String sql = "update account set balance = ? where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, amount + checkBalance(userId));
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void withdrawal(double amount, int userId) throws SQLException {
        String sql = "update account set balance = ? where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, checkBalance(userId) - amount);
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void transfer(double amount, int userId, int userId2) throws SQLException {
        String sql = "update account set balance = ? where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, checkBalance(userId) - amount);
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();

        String sql2 = "update account set balance = ? where userId = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setDouble(1, checkBalance(userId2) + amount);
        preparedStatement2.setInt(2, userId2);
        preparedStatement2.executeUpdate();
    }

    @Override
    public void createAccount(User user) throws SQLException {
        if (getCount(user.getId()) >= 1) {
            System.out.println("You already have an account");
            return;
        }
        System.out.println(user.getId());
        String sql = "insert into account (balance, userId, status) values (0, ?, 'pending')";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public int getCount(int userId) throws SQLException {
        String sql = "select count(userId) from account where userId = " + userId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public String getStatus(int userId) throws SQLException {
        String sql = "select status from account where userId=" + userId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return "";
    }

    @Override
    public List<Account> getAllStatus() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "CALL getAllStatus()";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int balance = resultSet.getInt(1);
            int accountNumber = resultSet.getInt(2);
            int userId = resultSet.getInt(3);
            String status = resultSet.getString(4);
            Account account = new Account(balance, accountNumber, userId, status);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public void employeeSetStatus(String status, int userId) throws SQLException {
        String sql = "update account set status=? where userId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, status);
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();
    }

    //Transaction override methods
    @Override
    public List<Transactions> getTransactionsByUserId(int account_id) throws SQLException {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "select * from transactions where account_Id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int transaction_id = resultSet.getInt(1);
            int account_id_to = resultSet.getInt(3);
            double amount = resultSet.getDouble(4);
            String type = resultSet.getString(5);
            String status = resultSet.getString(6);
            String date = resultSet.getString(7);
            transactions.add(new Transactions(transaction_id, account_id, account_id_to, amount, type, status, date));
        }
        return transactions;
    }

    @Override
    public void setTransaction(int account_id, int account_id_to, double amount, String type, String status) throws SQLException {
        String sql = "insert into transactions (account_id, account_id_to, amount, type, status) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account_id);
        preparedStatement.setInt(2, account_id_to);
        preparedStatement.setDouble(3, amount);
        preparedStatement.setString(4, type);
        preparedStatement.setString(5, status);
        preparedStatement.executeUpdate();
    }
}