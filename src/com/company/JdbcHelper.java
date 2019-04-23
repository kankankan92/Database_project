package com.company;

import java.sql.*;

public class JdbcHelper {

    private static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mydb", "postgres", "");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getResult(String query){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Проблема с БД");
        }
        return rs;
    }

    public static void runQuery(String query){
        Statement stmt = null;
        try {
            stmt = getConnection().createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Проблема с БД");
        }
    }
}
