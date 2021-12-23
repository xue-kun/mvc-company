package com.xk.dao;

import com.xk.entity.User;
import com.xk.utils.DataSourceFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    /*登陆*/
    public User Login(String name){
        User NewUser=null;
        PreparedStatement preparedStatement=null;
        String sql="select * from c_user where username=?";
        ResultSet resultSet=null;
        try {
            preparedStatement= DataSourceFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                NewUser=new User(resultSet.getString("username"),resultSet.getString("password"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return NewUser;
    }


    /*注册*/
    public int register(User user){
        PreparedStatement preparedStatement=null;
        int sum=0;
        String sql="insert into c_user(username,password) values(?,?)";
        try {
            preparedStatement=DataSourceFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            sum=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return sum;

    }
}
