package com.xk.controller;

import com.xk.dao.DeptDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmpServletView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeptDao deptDao=new DeptDao();

        req.setAttribute("deptlist",deptDao.listDept());
        req.getRequestDispatcher("addemp.jsp").forward(req, resp);
    }
}
