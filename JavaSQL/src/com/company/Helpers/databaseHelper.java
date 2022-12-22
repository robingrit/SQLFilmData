package com.company.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseHelper {
    // Declares and initializes variables for the JDBC driver, database type, server, and port number.
    public static String driver = "jdbc";
    public static String dbType = "mysql";
    public static String server = "localhost";
    public static int portNo = 3306;


    // This method takes a database name as input and returns a Connection object to the specified database.
    public static Connection DbConnect(String database) {
        // Builds the connection string using the variables for the driver, database type, server, and port number.
        String constr = driver + ":" +
                dbType + "://" +
                server +  ":" + portNo +
                "/" + database;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(constr, "root", "123123");
        } catch (SQLException e) {
            System.out.println("databas kan ej anslutas");
            e.printStackTrace();
        }

        return conn;
    }

}
