package com.xk.dao;

import com.xk.entity.Emp;
import com.xk.utils.DataSourceFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    /*查询emp集合*/
    public List<Emp> listEmp(){
        List<Emp> empList=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select *,d.name dept_name from c_emp e,c_dept d where e.dept_id=d.dept_id";
        try {
            preparedStatement= DataSourceFactory.getConnection().prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer emp_id=resultSet.getInt("emp_id");
                String name=resultSet.getString("name");
                String sex=resultSet.getString("sex");
                String phone=resultSet.getString("phone");
                Integer salary=resultSet.getInt("salary");
                Integer dept_id=resultSet.getInt("dept_id");
                String dept_name=resultSet.getString("dept_name");
                Emp emp=new Emp(emp_id,name,sex,phone,salary,dept_id,dept_name);
                empList.add(emp);
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

        return empList;
    }


    /*添加*/
    public int addEmp(Emp emp){
        PreparedStatement preparedStatement=null;
        Integer num=0;
        String sql="insert into c_emp set name=?,sex=?,phone=?,salary=?,dept_id=?";
        try {
            preparedStatement=DataSourceFactory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,emp.getName());
            preparedStatement.setString(2,emp.getSex());
            preparedStatement.setString(3,emp.getPhone());
            preparedStatement.setInt(4,emp.getSalary());
            preparedStatement.setInt(5,emp.getDept_id());
            num=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    /*删除*/
    public int deleteEmp(Integer emp_id){
        PreparedStatement preparedStatement=null;
        Integer sum=0;
        String sql="delete from c_emp where emp_id=?";
        try {
            preparedStatement=DataSourceFactory.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,emp_id);
            sum=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return sum;

    }
}
