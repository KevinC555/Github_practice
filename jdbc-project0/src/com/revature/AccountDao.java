package com.revature;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    double checkBalance(int userId) throws SQLException;
    void deposit(double amount, int userId) throws SQLException;
    void withdrawal(double amount, int userId) throws SQLException;
    void transfer(double amount, int userId, int userId2) throws SQLException;
    void createAccount(User user) throws SQLException;
    int getCount(int userId) throws SQLException;
    String getStatus(int userId) throws SQLException;
    List<Account> getAllStatus() throws SQLException;
    void employeeSetStatus(String status, int userId) throws SQLException;
}
