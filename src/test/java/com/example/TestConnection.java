package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/forum1", "root", "123456");
            System.out.println("连接成功！");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}