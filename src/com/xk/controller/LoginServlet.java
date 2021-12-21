package com.xk.controller;

import com.xk.dao.UserDao;
import com.xk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
            String password=req.getParameter("password");
            User user=new User(username,password);
            User user1=new UserDao().Login(user);

            if (user1.getPassword()!= null && user1.getPassword().equals(password)){
                resp.sendRedirect("emplist");
            }else {
                resp.sendRedirect("login");
            }
        }

}
