package com.xk.controller;

import com.xk.dao.DeptDao;
import com.xk.dao.EmpDao;
import com.xk.entity.Dept;
import com.xk.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateEmpServletView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmpDao empDao=new EmpDao();
        Emp emp=empDao.selectEmp(Integer.parseInt(req.getParameter("emp_id")));
        DeptDao deptDao=new DeptDao();
        List<Dept> deptList=deptDao.listDept();
        req.setAttribute("emp",emp);
        req.setAttribute("deptlist",deptList);
        req.getRequestDispatcher("updateemp.jsp").forward(req,resp);

    }
}
