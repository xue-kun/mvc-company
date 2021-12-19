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
}
