package com.xk.controller;

import com.xk.dao.EmpDao;
import com.xk.entity.Emp;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        EmpDao empDao=new EmpDao();

        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String phone=req.getParameter("phone");
        Integer salary=Integer.parseInt(req.getParameter("salary"));
        Integer dept_id=Integer.parseInt(req.getParameter("dept_id"));

        empDao.addEmp(new Emp(name,sex,phone,salary,dept_id));

        resp.sendRedirect("emplist");


    }
}
