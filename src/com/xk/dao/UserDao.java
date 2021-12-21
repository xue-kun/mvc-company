package com.xk.dao;

import com.xk.entity.User;
import com.xk.utils.DataSourceFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User Login(User user){
        User user1=new User();
        PreparedStatement preparedStatement;
        String sql="select password from c_user where username=?";
        ResultSet resultSet;
        try {
            preparedStatement= DataSourceFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String password=resultSet.getString("password");
                user1.setUsername(user.getUsername());
                user1.setPassword(password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user1;

    }
}
