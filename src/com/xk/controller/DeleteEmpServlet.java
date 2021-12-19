package com.xk.controller;

import com.xk.dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmpDao empDao=new EmpDao();
        System.out.println(req.getParameter("dept_id"));
        Integer emp_id=Integer.parseInt(req.getParameter("dept_id"));
        empDao.deleteEmp(emp_id);
        resp.sendRedirect("emplist");


    }
}
