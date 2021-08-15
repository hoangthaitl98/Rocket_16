package com.vti.backend.datalayer;

import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository{
    @Override
    public List<User> getUserByProjectId(int id){

        List<User> userList = new ArrayList<>() ;
        try {
            String query = "SELECT u.*" +
                    "FROM `ProjectAndUser` pau " +
                    "JOIN `User` u ON u.id = pau.userId " +
                    "WHERE pau.projectId = '" + id + "'";
            Statement statement = JDBCUtils.getInstance().getStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("FullName"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> getAllMagager() {
        List<User> managerList = new ArrayList<>();
        try {
            String sql = "SELECT `u`.*" +
                    "FROM `ProjectAndUser` pau " +
                    "JOIN `User` u ON u.id = pau.userId " +
                    "WHERE `Role` = 'MANAGER';";

            Statement statement = JDBCUtils.getInstance().getStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User manager = new User(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
                managerList.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managerList;
    }

    @Override
    public boolean login(String email, String password) {
        try {
            String query = "SELECT * FROM `user` WHERE Email = '" + email + "' AND password = '" + password + "'";

            Statement statement = JDBCUtils.getInstance().getStatement();

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
