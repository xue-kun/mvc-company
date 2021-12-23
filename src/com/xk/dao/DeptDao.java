package com.xk.dao;

import com.xk.entity.Dept;
import com.xk.entity.Emp;
import com.xk.utils.DataSourceFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {

    /*查询dept集合*/
    public List<Dept> listDept(){
        List<Dept> deptList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from c_dept";
        try {
            preparedStatement= DataSourceFactory.getConnection().prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer dept_id=resultSet.getInt("dept_id");
                String name=resultSet.getString("name");
                String location=resultSet.getString("location");

                deptList.add(new Dept(dept_id,name,location));
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

        return deptList;
    }

    /*删除dept*/
    public int deleteDept(int[] ints){
        int sum=0;
        PreparedStatement preparedStatement;
        String sql="delete from c_dept where dept_id=?";
        for (int i = 0; i < ints.length ; i++) {
            try {
                preparedStatement=DataSourceFactory.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1,ints[i]);
                preparedStatement.executeUpdate();
                sum++;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return sum;
    }

    /*增加部门*/
    public int addDept(Dept dept){
        int sum=0;
        PreparedStatement preparedStatement;
        String sql="insert into c_dept(name,location) values(?,?)";
        try {
            preparedStatement=DataSourceFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,dept.getName());
            preparedStatement.setString(2,dept.getLocation());
            sum=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sum;

    }
}
