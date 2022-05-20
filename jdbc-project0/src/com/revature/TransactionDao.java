package com.revature;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {
    List<Transactions> getTransactionsByUserId(int account_Id) throws SQLException;
    void setTransaction(int account_id, int account_id_to, double amount, String type, String status) throws SQLException;
}
