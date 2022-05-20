package com.revature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    Connection connection;

    public UserDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public boolean login(User user) throws SQLException {
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            System.out.println("Login successful");
            return true;
        }
        System.out.println("Login Failed");
        return false;
    }

    @Override
    public void signUp(User user) throws SQLException {
        String sql = "insert into user (name, username, password) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Account Created");
        else
            System.out.println("Account Creation Failed");
    }

    @Override
    public boolean userCheck(User user) throws SQLException {
        String sql = "select account_type from user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return (resultSet.getString(1).equalsIgnoreCase("employee"));
        }
        return false;
    }
}
