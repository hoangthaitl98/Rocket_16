package frontend;

import backend.DepartmentDAO;
import entity.Department;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Program2 {
    public static void main(String[] args) throws SQLException, IOException {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        for (Department department : departmentDAO.getDepartments()) {
            System.out.println(department.toString());
        }
    }
}
