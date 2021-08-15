package com.vti.backend.datalayer;

import com.vti.entity.Account;
import com.vti.utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements  IRepository{
    public List<Account> getListAccount(){
        List<Account> accountList = new ArrayList<>();
        try {
            String query = "SELECT * FROM `account`";

            Statement statement = JDBCUtils.getInstance().getStatement();

            ResultSet resultset = statement.executeQuery(query);

            while (resultset.next()){
                Account account = new Account(resultset.getInt("AccountID"),
                        resultset.getString("FullName"),
                        resultset.getString("Email"),
                        resultset.getString("UserName"));
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public boolean createAccount(String fullname, String email, String username) {
        try {
            String sql = "INSERT INTO account (FullName, Email, UserName) " +
                    "VALUE ('" + fullname + "', '" + email + "', '" + username + "')";

            Statement statement = JDBCUtils.getInstance().getStatement();

            int resultSet = statement.executeUpdate(sql);
            if (resultSet > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getAccountById(int id) {
        Account account = null;
        try {
            String query = "SELECT * FROM account WHERE AccountID = " + id;
            Statement statement = JDBCUtils.getInstance().getStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                account = new Account(resultSet.getInt("AccountID"),
                        resultSet.getString("FullName"),
                        resultSet.getString("Email"),
                        resultSet.getString("UserName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public boolean isAccountExist(String username) {
        try {
            String query = "SELECT * FROM account WHERE UserName = '" + username + "'";
            System.out.println();
            Statement statement = JDBCUtils.getInstance().getStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account updateAccountById(int id, String email, String fullname, String username) {
        Account account = null;
        try {
            String updateQuery = "UPDATE account " +
                    "SET Email =  '" + email + "'" + ", FullName =  '" + fullname + "'" + ", UserName = '" + username + "'" +
                    " WHERE AccountId = " + id;

            Statement statement = JDBCUtils.getInstance().getStatement();

            int resultSet = statement.executeUpdate(updateQuery);

            if (resultSet > 0) {
                String query = "SELECT * FROM account WHERE AccountId = " + id;

                ResultSet resultSet1 = statement.executeQuery(query);
                while (resultSet1.next()){
                    account = new Account(resultSet1.getInt("AccountID"),
                            resultSet1.getString("FullName"),
                            resultSet1.getString("Email"),
                            resultSet1.getString("UserName"));
                }
                return account;
            }else return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public boolean deleteAccount(int id) {
        try {
            String query = "DELETE FROM account WHERE AccountId = '" + id + "'";

            Statement statement = JDBCUtils.getInstance().getStatement();

            int resultSet = statement.executeUpdate(query);
            if (resultSet > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
