package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionProxy {
    
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // 1. Driver 濡쒕뵫
            Class.forName("com.mysql.cj.jdbc.Driver"); // ?겢?옒?뒪 濡쒕뵫?맆?븣 ?븳踰덈쭔 泥섎━?빐以?
            // 2. Connection ?뿰寃?
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/fooddb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
                    "ssafy");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    
}