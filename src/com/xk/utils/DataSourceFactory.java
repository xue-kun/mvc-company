package com.xk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceFactory {


    public static Connection getConnection(){
        Connection connection=null;
        Properties properties=new Properties();
        InputStream inputStream=DataSourceFactory.class.getClassLoader().getResourceAsStream("mysql.properties");
        try {
            properties.load(inputStream);
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(
                    properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));

        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;


    }
}
