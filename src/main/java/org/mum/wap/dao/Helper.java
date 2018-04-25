/**
 * @author Abdelrahman
 */
package org.mum.wap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Helper {


    private Connection dbConn;
    private  PreparedStatement crunchifyPrepareStat;

    public  Helper(){

    }

    public void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {

        this.dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling", "root", "admin");
            if (dbConn != null) {
                log("MySQL Connection Success!");
            }
        } catch (SQLException e) {
            log("MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }

    }

    public long addDataToDB(String pInsertStatement) {

        long insertedId=0;

        try {
            crunchifyPrepareStat = dbConn.prepareStatement(pInsertStatement);
            // execute insert SQL statement
            crunchifyPrepareStat.executeUpdate();

            try (ResultSet generatedKeys = crunchifyPrepareStat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                     insertedId = generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            return  insertedId;
        } catch (

                SQLException e) {
            e.printStackTrace();
            return  insertedId;
        }
    }

    public ResultSet getDataFromDB(String getQueryStatement) {

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

    public void closeConnection() {

        try {
            crunchifyPrepareStat.close();
            dbConn.close(); // connection close
        } catch (SQLException e) {
             e.printStackTrace();
         }
    }

        public void log(String string) {
        System.out.println(string);

    }
}
