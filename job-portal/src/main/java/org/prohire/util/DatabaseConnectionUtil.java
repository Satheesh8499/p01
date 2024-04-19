package org.prohire.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseConnectionUtil {
    static String url = "jdbc:mysql://localhost:3306/prohire";
    static String username = "root";
    static String password = "beastF5$@";
   private static  Connection connection;
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database!");
            return connection;
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return  connection;
    }


}
