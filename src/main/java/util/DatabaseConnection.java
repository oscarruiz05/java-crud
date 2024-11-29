package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "test";
    public static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection != null) return connection;
        connection = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
        return connection;
    }
}
