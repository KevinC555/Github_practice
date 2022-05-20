package com.revature;

public class UserDaoFactory {
    public static UserDao dao;

    private UserDaoFactory() {
    }

    public static UserDao getUserDao() {
        if (dao == null)
            dao = new UserDaoImpl();
        return dao;
    }
}
