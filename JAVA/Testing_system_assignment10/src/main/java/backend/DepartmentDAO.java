package backend;

import entity.Department;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartmentDAO {
    private List<Department> departments = new ArrayList<>();

    public List<Department> getDepartments () throws SQLException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection myConnection = DriverManager.getConnection(url, username, password);
        Statement statement = myConnection.createStatement();
        ResultSet result = statement.executeQuery("SELECT  * FROM department");
        while (result.next()){
            Department department = new Department(result.getInt("DepartmentID"),
                    result.getString("DepartmentName"));
            departments.add(department);
        }
        return departments;
    }
}
