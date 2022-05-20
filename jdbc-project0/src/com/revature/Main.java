package com.revature;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserDao dao = UserDaoFactory.getUserDao();
        AccountDaoImpl accountDao = AccountDaoFactory.getAccountDao();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            System.out.println("************************");
            System.out.println("Select from the options below");
            System.out.println("************************");
            System.out.println("PRESS 1: Login");
            System.out.println("PRESS 2: Sign Up");

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    // login
                    System.out.println("Enter Username: ");
                    String username = scanner.next();
                    System.out.println("Enter Password: ");
                    String password = scanner.next();
                    User user = new User();

                    user.setUsername(username);
                    user.setPassword(password);
                    if (dao.login(user)) {
                        if (dao.userCheck(user)) {
                            System.out.println("Employee Logged In");
                            EmployeeLogin(dao, accountDao, scanner, user);
                        } else {
                            System.out.println("Customer Logged In");
                            CustomerLogin(dao, accountDao, scanner, user);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter Name: ");
                    String name = scanner.next();
                    System.out.println("Enter Username: ");
                    String username = scanner.next();
                    System.out.println("Enter Password");
                    String password = scanner.next();
                    User user = new User();
                    user.setName(name);
                    user.setUsername(username);
                    user.setPassword(password);
                    dao.signUp(user);
                    break;
                }
            }
        }
    }


    public static void CustomerLogin(UserDao userDao, AccountDaoImpl accountDao, Scanner scanner, User user) throws SQLException {

        boolean flag = true;

        while (flag) {
            System.out.println("************************");
            System.out.println("Select from the options below");
            System.out.println("************************");
            System.out.println("PRESS 1: OPEN NEW BANK ACCOUNT");
            System.out.println("PRESS 2: ACCESS ACCOUNT");
            System.out.println("PRESS 3: EXIT");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    accountDao.createAccount(user);
                    break;
                }
                case 2: {
                    if (!accountDao.getStatus(user.getId()).equals("approved")) {
                        System.out.println("Your account is pending or declined");
                    } else {
                        CustomerAccountAccess(userDao, accountDao, scanner, user);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Thank You");
                    System.out.println("Exiting...");
                    flag = false;
                    ConnectionFactory.CloseConnection();
                    break;
                }
            }
        }
    }

    public static void CustomerAccountAccess(UserDao userDao, AccountDaoImpl accountDao, Scanner scanner, User user) throws SQLException {
        boolean flag = true;

        while (flag) {
            System.out.println("************************");
            System.out.println("Select from the options below");
            System.out.println("************************");
            System.out.println("PRESS 1: CHECK STATUS");
            System.out.println("PRESS 2: CHECK BALANCE");
            System.out.println("PRESS 3: DEPOSIT");
            System.out.println("PRESS 4: WITHDRAWAL");
            System.out.println("PRESS 5: TRANSFER");
            System.out.println("PRESS 6: EXIT");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println(accountDao.getStatus(user.getId()).toUpperCase(Locale.ROOT));
                    break;
                }
                case 2: {
                    System.out.println("Balance is: " + accountDao.checkBalance(user.getId()));
                    break;
                }
                case 3: {
                    System.out.println("How much are you depositing?");
                    double amount = scanner.nextDouble();
                    if (amount < 0 || !accountDao.getStatus(user.getId()).equals("approved")) {
                        System.out.println("You cannot deposit a negative amount or account either pending or declined!");
                        accountDao.setTransaction(user.getId(), user.getId(), amount, "deposit", "rejected");
                    } else {
                        System.out.println("Your deposit was successful");
                        accountDao.deposit(amount, user.getId());
                        accountDao.setTransaction(user.getId(), user.getId(), amount, "deposit", "accepted");
                    }
                    break;
                }
                case 4: {
                    System.out.println("How much are you withdrawing?");
                    double amount = scanner.nextDouble();
                    if (amount > accountDao.checkBalance(user.getId()) || amount < 0 || !accountDao.getStatus(user.getId()).equals("approved")) {
                        System.out.println("Insufficient funds or account either pending or declined!");
                        accountDao.setTransaction(user.getId(), user.getId(), amount, "withdraw", "rejected");
                    } else {
                        System.out.println("Your withdrawal was successful");
                        accountDao.withdrawal(amount, user.getId());
                        accountDao.setTransaction(user.getId(), user.getId(), amount, "withdraw", "accepted");
                    }
                    break;
                }
                case 5: {
                    System.out.println("How much are you transferring");
                    double amount = scanner.nextDouble();
                    System.out.println("Enter account Id you are transferring to");
                    int id = scanner.nextInt();
                    if (amount > accountDao.checkBalance(user.getId()) || amount < 0 || !accountDao.getStatus(user.getId()).equals("approved")) {
                        System.out.println("Insufficient funds or account either pending or declined!");
                        accountDao.setTransaction(user.getId(), id, amount, "transfer", "rejected");
                    } else {
                        accountDao.transfer(amount, user.getId(), id);
                        System.out.println("Your transfer was successful");
                        accountDao.setTransaction(user.getId(), id, amount, "transfer", "accepted");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Thank You");
                    System.out.println("Exiting...");
                    flag = false;
                    ConnectionFactory.CloseConnection();
                    break;
                }
            }
        }
    }

    public static void EmployeeLogin(UserDao userDao, AccountDaoImpl accountDao, Scanner scanner, User user) throws SQLException {
        boolean flag = true;

        while (flag) {
            System.out.println("************************");
            System.out.println("Select from the options below");
            System.out.println("************************");
            System.out.println("PRESS 1: CHECK ACCOUNT STATUS");
            System.out.println("PRESS 2: UPDATE A CUSTOMER ACCOUNT");
            System.out.println("PRESS 3: GET TRANSACTIONS LIST");
            System.out.println("PRESS 4: EXIT");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    List<Account> accounts = accountDao.getAllStatus();
                    for (Account account : accounts) {
                        System.out.println(account);
                    }
                    break;
                }
                case 2: {
                    EmployeeSetStatus(userDao, accountDao, scanner, user);
                    break;
                }
                case 3: {
                    System.out.println("Enter customer Id to get transaction list");
                    int receipt = scanner.nextInt();
                    List<Transactions> transactions = accountDao.getTransactionsByUserId(receipt);
                    for (Transactions transaction: transactions) {
                        System.out.println(transaction);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Thank You");
                    System.out.println("Exiting...");
                    flag = false;
                    ConnectionFactory.CloseConnection();
                    break;
                }
            }
        }
    }

    public static void EmployeeSetStatus(UserDao userDao, AccountDaoImpl accountDao, Scanner scanner, User user) throws SQLException {
        boolean flag = true;

        while (flag) {
            System.out.println("************************");
            System.out.println("Select from the options below");
            System.out.println("************************");
            System.out.println("PRESS 1: To Approve Status");
            System.out.println("PRESS 2: To Decline Status");
            System.out.println("PRESS 3: To Leave Status Pending");
            System.out.println("PRESS 4: EXIT");
            int input = scanner.nextInt();
            System.out.println("Enter User Id");
            int userId = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("Approved");
                    accountDao.employeeSetStatus("approved", userId);
                    break;
                }
                case 2: {
                    System.out.println("Declined");
                    accountDao.employeeSetStatus("declined", userId);
                    break;
                }
                case 3: {
                    System.out.println("Pending");
                    accountDao.employeeSetStatus("pending", userId);
                    break;
                }
                case 4: {
                    System.out.println("Thank You");
                    System.out.println("Exiting...");
                    flag = false;
                    ConnectionFactory.CloseConnection();
                    break;
                }
            }
        }
    }
}
