package org.mum.wap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Helper {

    public Helper(){}

    public static Connection dbConn = null;
    public static PreparedStatement crunchifyPrepareStat = null;

    public static void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {

            dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling", "root", "admin");
            if (dbConn != null) {
                log("MySQL Connection Success!");
            }
        } catch (SQLException e) {
            log("MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }

    }

    public static void addDataToDB(String companyName, String address, int totalEmployee, String webSite) {

        try {
            String insertQueryStatement = "INSERT  INTO  Employee  VALUES  (?,?,?,?)";

            crunchifyPrepareStat = dbConn.prepareStatement(insertQueryStatement);
            crunchifyPrepareStat.setString(1, companyName);
            crunchifyPrepareStat.setString(2, address);
            crunchifyPrepareStat.setInt(3, totalEmployee);
            crunchifyPrepareStat.setString(4, webSite);

            // execute insert SQL statement
            crunchifyPrepareStat.executeUpdate();
            log(companyName + " added successfully");
        } catch (

                SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getDataFromDB(String getQueryStatement) {

        try {

            crunchifyPrepareStat = dbConn.prepareStatement(getQueryStatement);

            // Execute the Query, and get a java ResultSet
            return crunchifyPrepareStat.executeQuery();
        } catch (

                SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void closeConnection() {

        try {
            crunchifyPrepareStat.close();
            dbConn.close(); // connection close
        } catch (SQLException e) {
             e.printStackTrace();
         }
    }

        public static void log(String string) {
        System.out.println(string);

    }
}
