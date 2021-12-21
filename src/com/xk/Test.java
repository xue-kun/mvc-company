package com.xk;

import com.xk.entity.User;
import com.xk.utils.DataSourceFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {


    public static void main(String[] args) {
            PreparedStatement preparedStatement;
            String sql="select password from c_user where username=?";
            ResultSet resultSet;
            try {
                preparedStatement= DataSourceFactory.getConnection().prepareStatement(sql);
                preparedStatement.setString(1,"张三");
                resultSet=preparedStatement.executeQuery();
                while (resultSet.next()){
                    String password=resultSet.getString("password");
                    System.out.println(password);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }



