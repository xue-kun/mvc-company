package com.xk.controller;

import com.xk.dao.UserDao;
import com.xk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if ( !"".equals(username) && !"".equals(password)){
            System.out.println(username);
            System.out.println(password);
            User user=new User(username,password);
            new UserDao().register(user);
            resp.sendRedirect("login");
        }else {
            resp.sendRedirect("registerView");
        }

    }
}
