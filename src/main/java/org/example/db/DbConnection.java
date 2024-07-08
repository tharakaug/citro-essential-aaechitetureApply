package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private final Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/citro_essentional_oil",
                "root",
                "ijse@123"
        );
    }
    public static DbConnection getDbConnection() throws SQLException, ClassNotFoundException {
        return (dbConnection == null) ? dbConnection = new DbConnection() : dbConnection;
    }
    public Connection getConnection() {
        return connection;
    }
}
