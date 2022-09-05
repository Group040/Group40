package com.example.inventorysystem.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database
 * @author Julian Jupiter
 *
 */
public class DBCon {

    private static final Logger logger = Logger.getLogger(DBCon.class.getName());
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3307/inventory";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private DBCon() {

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            System.out.println("Driver not Loaded");

        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Connection is established");
            System.out.println(connection);
            return connection;

        } catch (SQLException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }
        System.out.println("Connection not established");

        return connection;
    }

}