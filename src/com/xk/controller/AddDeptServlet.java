package com.xk.controller;

import com.xk.dao.DeptDao;
import com.xk.entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/adddept")
public class AddDeptServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String location=req.getParameter("location");
        Dept dept=new Dept(name,location);
        DeptDao deptDao=new DeptDao();
        deptDao.addDept(dept);

        resp.sendRedirect("deptlist");
    }
}
