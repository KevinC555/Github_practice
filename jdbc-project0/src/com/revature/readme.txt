MY USER TABLE

mysql> describe user;
+--------------+-----------------------------+------+-----+---------+----------------+
| Field        | Type                        | Null | Key | Default | Extra          |
+--------------+-----------------------------+------+-----+---------+----------------+
| id           | int                         | NO   | PRI | NULL    | auto_increment |
| name         | char(50)                    | YES  |     | NULL    |                |
| username     | char(50)                    | YES  | UNI | NULL    |                |
| password     | char(50)                    | YES  |     | NULL    |                |
| account_type | enum('customer','employee') | NO   |     | NULL    |                |
| status       | enum('approved','declined') | NO   |     | NULL    |                |
+--------------+-----------------------------+------+-----+---------+----------------+
6 rows in set (0.01 sec)

mysql> select* from user;
+----+-----------+-----------+----------+--------------+----------+
| id | name      | username  | password | account_type | status   |
+----+-----------+-----------+----------+--------------+----------+
| 10 | Josh      | Admin     | password | employee     | approved |
| 20 | Customer1 | Customer1 | password | customer     | approved |
| 21 | Customer2 | Customer2 | password | customer     | approved |
+----+-----------+-----------+----------+--------------+----------+
3 rows in set (0.00 sec)


MY ACCOUNT TABLE

mysql> describe account;
+---------------+---------------------------------------+------+-----+---------+----------------+
| Field         | Type                                  | Null | Key | Default | Extra          |
+---------------+---------------------------------------+------+-----+---------+----------------+
| balance       | double(15,2)                          | YES  |     | NULL    |                |
| accountNumber | int                                   | NO   | PRI | NULL    | auto_increment |
| userId        | int                                   | YES  | MUL | NULL    |                |
| status        | enum('pending','approved','declined') | YES  |     | NULL    |                |
+---------------+---------------------------------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> select* from account;
+---------+---------------+--------+----------+
| balance | accountNumber | userId | status   |
+---------+---------------+--------+----------+
|  300.00 |            16 |     20 | approved |
|  300.00 |            17 |     21 | approved |
+---------+---------------+--------+----------+
2 rows in set (0.00 sec)


MY TRANSACTIONS TABLE

mysql> describe transactions;
+----------------+---------------------------------------+------+-----+-------------------+-------------------+
| Field          | Type                                  | Null | Key | Default           | Extra             |
+----------------+---------------------------------------+------+-----+-------------------+-------------------+
| transaction_id | int                                   | NO   | PRI | NULL              | auto_increment    |
| account_id     | int                                   | YES  | MUL | NULL              |                   |
| account_id_to  | int                                   | YES  | MUL | NULL              |                   |
| amount         | double(11,2)                          | YES  |     | NULL              |                   |
| type           | enum('deposit','withdraw','transfer') | YES  |     | NULL              |                   |
| status         | enum('pending','rejected','accepted') | YES  |     | NULL              |                   |
| date           | timestamp                             | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+----------------+---------------------------------------+------+-----+-------------------+-------------------+
7 rows in set (0.00 sec)

mysql> select * from transactions;
+----------------+------------+---------------+--------+----------+----------+---------------------+
| transaction_id | account_id | account_id_to | amount | type     | status   | date                |
+----------------+------------+---------------+--------+----------+----------+---------------------+
|             14 |         20 |            20 | 500.00 | deposit  | accepted | 2022-05-16 13:07:13 |
|             15 |         20 |            20 | 300.00 | withdraw | accepted | 2022-05-16 13:07:19 |
|             16 |         20 |            21 | 100.00 | transfer | accepted | 2022-05-16 13:07:44 |
|             17 |         21 |            21 | 400.00 | deposit  | accepted | 2022-05-16 13:08:42 |
|             18 |         21 |            21 | 100.00 | withdraw | accepted | 2022-05-16 13:08:46 |
|             19 |         21 |            20 | 200.00 | transfer | accepted | 2022-05-16 13:08:52 |
|             20 |         20 |            20 | 200.00 | deposit  | accepted | 2022-05-16 15:16:48 |
|             21 |         20 |            20 | 200.00 | withdraw | accepted | 2022-05-16 15:16:52 |
|             22 |         20 |            20 | 100.00 | deposit  | accepted | 2022-05-16 15:16:56 |
|             23 |         20 |            21 | 100.00 | transfer | accepted | 2022-05-16 15:17:01 |
+----------------+------------+---------------+--------+----------+----------+---------------------+
10 rows in set (0.00 sec)



In this project we created a banking application. There are many methods and override statements conjoined with mysql

In User, we use methods and interfaces to log in, userCheck and signUp
The login method determines whether the user is allowed to log in based on existing username and password
The userCheck determines whether the user logging in is a customer or an employee
The signUp method allows the user to signUp. No customers are allowed to sign up as employee though, so we have a set employee as Admin with a password of password

Upon logging in as a customer once you have signed up for an account, you will be given 3 options, open new bank account, access account, and exit.
Once you create a username and password you still need to create a bank account which is option 1, then you will be able to access account once the employee sets your account to approved.

Once you have been approved we move to CustomerAccountAccess class that gives you more options, like checking account status, checking balance, make deposits and withdrawals, transfers and finally exiting the system.

In EmployeeLogin class we handle the options for checking account status of all customers, this way if any accounts are still pending review, we can go ahead and update them.
Once we see there are accounts to approve, we can use case 2 that allows us to set their status to either approved, declined or leave pending, then finally exit the program.
If we choose to update an account status it takes us to EmployeeSetStatus method which allows us to choose from the above options, apporve, decline, leave pending.

In our AccountDaoImpl we have methods for checking balance, deposit, withdraw, transfer, createAccount, getCount, getStatus, getAllStatus, employeeSetStatus, getTransactionByUserId, and setTransaction.

In our getTransactionsByUserId we are listing all transactions that have been stored in memory by our application
With setTransaction we are setting the transaction at each method in main for deposit, withdraw and transfer.