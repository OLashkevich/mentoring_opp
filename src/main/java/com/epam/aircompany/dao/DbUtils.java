package com.epam.aircompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Olga Lashkevich
 */
public class DbUtils {

    private static String url = "jdbc:h2:tcp://localhost/~/test";
    private static String username = "sa";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
