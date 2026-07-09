package com.kaarthi.library.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Configure your local MySQL database credentials before running the application.
    private static final String URL = "jdbc:mysql://localhost:3306/library_management_system";
    private static final String USERNAME = "<YOUR_MYSQL_USERNAME>";
    private static final String PASSWORD = "<YOUR_MYSQL_PASSWORD>";


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed",e);
        }
    }
}
