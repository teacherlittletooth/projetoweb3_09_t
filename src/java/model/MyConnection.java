package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307/clube";
        String user = "root";
        String pass = "";
        
        Class.forName(driver);
       Connection con = DriverManager.getConnection(url,user,pass);
       return con;
    }
}
