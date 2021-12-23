package com.xk.controller;

import com.xk.dao.DeptDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletedept")
public class DeleteDeptServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids=req.getParameter("dept_ids");
        String[] strings=ids.split(",");
        int[] ints=new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i]=Integer.parseInt(strings[i]);
        }
        DeptDao deptDao=new DeptDao();
        deptDao.deleteDept(ints);
        resp.sendRedirect("deptlist");
    }


}
