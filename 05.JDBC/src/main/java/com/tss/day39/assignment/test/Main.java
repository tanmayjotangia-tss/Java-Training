package com.tss.day39.assignment.test;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TestDB";
        String username = "postgres";
        String password = "Temp@123456";

        Connection conn = null;
        Savepoint save1 = null;

        try{
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Default AutoCommit: " + conn.getAutoCommit());

            conn.setAutoCommit(false);
            System.out.println("AutoCommit after change: " + conn.getAutoCommit());

            PreparedStatement pstmt1 = conn.prepareStatement("UPDATE accounts SET balance=40000 WHERE name = ?");
            pstmt1.setString(1,"Tanmay");

            pstmt1.executeUpdate();
//            conn.commit();
            save1 = conn.setSavepoint("Savepoint1");

            System.out.println("Transaction 1 committed successfully");



            PreparedStatement pstmt2 = conn.prepareStatement("UPDATE accounts SET balance=100 WHERE name = ?");
            pstmt2.setString(1,"Tanmay");
            pstmt2.executeUpdate();

            PreparedStatement pstmt3 = conn.prepareStatement("UPDATE accounts SET balance=-90 WHERE name = ?");
            pstmt3.setString(1,"Rahul");
            pstmt3.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            try{
                if(conn != null && save1 != null){
                    conn.rollback(save1);
                    conn.commit();
                    System.out.println("Transaction rollback successfully");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
