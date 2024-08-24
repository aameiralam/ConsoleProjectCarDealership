package com.jdbcLearning.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {


    public static Connection createConnection() {

        Connection connectionStep2 = null;

        final String Db_Name = "dealership";
        final String Db_url = "jdbc:mysql://localhost:3306/" + Db_Name;
        final String Db_username = "root";
        final String Db_password = "Chittagong100!";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectionStep2 = DriverManager.getConnection(Db_url, Db_username, Db_password);


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connectionStep2;
    }
}