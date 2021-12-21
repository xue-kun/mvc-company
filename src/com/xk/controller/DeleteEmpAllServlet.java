package com.xk.controller;

import com.xk.dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteEmpAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       String ids=req.getParameter("ids");
       String[] strings=ids.split(",");
        Integer[] integers=new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i]= Integer.valueOf(strings[i]);
        }

        EmpDao empDao=new EmpDao();
        empDao.deleteAllEmp(integers);

        resp.sendRedirect("emplist");


    }
}
