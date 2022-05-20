package com.revature;

import java.sql.SQLException;

public interface UserDao {
    boolean login(User user) throws SQLException;
    boolean userCheck(User user) throws SQLException;
    void signUp(User user) throws SQLException;
}
