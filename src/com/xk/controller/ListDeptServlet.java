package com.xk.controller;

import com.xk.dao.DeptDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class ListDeptServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        DeptDao deptDao=new DeptDao();
        req.setAttribute("deptlist",deptDao.listDept());
        req.getRequestDispatcher("deptlist.jsp").forward(req, res);

    }

}
