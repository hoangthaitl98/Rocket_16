package com.vti.utils;

import java.sql.*;

public class JDBCUtils {
    public final String URL = "jdbc:mysql://localhost:3306/testing_system";
    public final String USERNAME = "root";
    public final String PASSWORD = "root";
    private static JDBCUtils instances;
    private Connection connection;

    public static JDBCUtils getInstance(){
        if (instances == null){
            instances = new JDBCUtils();
        }
        return instances;
    }

    private JDBCUtils(){
    }

    public void removeInstance() throws SQLException {
        closeConnection();
        instances = null;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public Statement getStatement() throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement;
    }

    public PreparedStatement getPreparedStatement (String sqlQuery) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery);
        return preparedStatement;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        else connection = null;
    }
}
