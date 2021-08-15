package com.vti.utils;

import java.sql.*;
import java.util.Scanner;

public class JDBCUtils {
    public final String URL = "jdbc:mysql://localhost:3306/testingsystem";
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

    /**
     * This class is Scanner utils.
     *
     * @Description: .
     * @author: NNDuy
     * @create_date: May 28, 2020
     * @version: 1.0
     * @modifer: NNDuy
     * @modifer_date: May 28, 2020
     */
    public static class ScannerUtils {

        private static Scanner scanner = new Scanner(System.in);

        /**
         * This method is used for input id.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @return
         */
        public static int inputId() {
            while (true) {
                int id = inputInt("Please input a id as int, please input again.");
                if (id > 0) {
                    return id;
                }
                // else
                System.out.println("Please input a id as int which must be greater than > 0, please input again.");
            }
        }

        /**
         * This method is used for input name.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @return
         */
        public static String inputName() {
            return inputString("Please input a name, please input again.");
        }

        /**
         * This method is used for input int.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @return
         */
        public static int inputInt() {
            return inputInt("Please input a number as int, please input again");
        }

        /**
         * This method is used for input id.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @param errorMessage
         * @return
         */
        public static int inputInt(String errorMessage) {
            while (true) {
                try {
                    return Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.err.println(errorMessage);
                }
            }
        }

        /**
         * This method is used for input float.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @param errorMessage
         * @return
         */
        public static float inputFloat(String errorMessage) {
            while (true) {
                try {
                    return Float.parseFloat(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.err.println(errorMessage);
                }
            }
        }

        /**
         * This method is used for input double.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @param errorMessage
         * @return
         */
        public static double inputDouble(String errorMessage) {
            while (true) {
                try {
                    return Double.parseDouble(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.err.println(errorMessage);
                }
            }
        }

        /**
         * This method is used for input String.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @param errorMessage
         * @return
         */
        public static String inputString(String errorMessage) {
            while (true) {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.err.println(errorMessage);
                }
            }
        }

        /**
         * This method is used for input age.
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @return
         */
        public static int inputAge() {
            while (true) {
                int age = inputInt("Wrong inputing! Please input an age as int, input again.");

                if (age <= 0) {
                    System.err.println("Wrong inputing! The age must be greater than 0, please input again.");

                } else {
                    return age;
                }
            }
        }

        /**
         * This method is used for input age greater than 18 .
         *
         * @Description: .
         * @author: NNDuy
         * @create_date: May 28, 2020
         * @version: 1.0
         * @modifer: NNDuy
         * @modifer_date: May 28, 2020
         * @return
         */
        public static int inputAgeGreaterThan18() {
            while (true) {
                int age = inputAge();

                if (age >= 18) {
                    return age;

                } else {
                    System.out.println("Wrong inputing! The age must be greater than 18, please input again.");
                }
            }
        }

    }
}
