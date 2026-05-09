package com.tss.day39.task.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    public static Connection connect() {
        try {
            if(connection == null){
                Properties props = new Properties();

                InputStream input = DBConnection.class
                        .getClassLoader()
                        .getResourceAsStream("db.properties");

                props.load(input);

                Class.forName(props.getProperty("db.driver"));

                connection = DriverManager.getConnection(props.getProperty("db.URL"),props.getProperty("db.USERNAME"), props.getProperty("db.PASSWORD"));

                System.out.println("Connection established successfully");

            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
