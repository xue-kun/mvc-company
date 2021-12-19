package com.xk.controller;

import com.xk.dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class ListEmpServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        EmpDao empDao=new EmpDao();
        req.setAttribute("emplist",empDao.listEmp());
        req.getRequestDispatcher("emplist.jsp").forward(req, res);

    }

}
