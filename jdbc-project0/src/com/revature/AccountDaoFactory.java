package com.revature;

public class AccountDaoFactory {
    public static AccountDaoImpl dao;

    private AccountDaoFactory() {
    }

    public static AccountDaoImpl getAccountDao() {
        if (dao == null)
            dao = new AccountDaoImpl();
        return dao;
    }
}
