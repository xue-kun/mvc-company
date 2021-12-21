package com.xk.controller;

import com.xk.dao.EmpDao;
import com.xk.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name=req.getParameter("name");
        String phone=req.getParameter("phone");
        String sex=req.getParameter("sex");
        Integer salary=Integer.parseInt(req.getParameter("salary"));
        Integer dept_id=Integer.parseInt(req.getParameter("dept_id"));
        Integer emp_id=Integer.parseInt(req.getParameter("emp_id"));
        Emp emp=new Emp(emp_id,name,sex,phone,salary,dept_id);
        EmpDao empDao=new EmpDao();
        empDao.updateEmp(emp);
        resp.sendRedirect("emplist");

    }
}
