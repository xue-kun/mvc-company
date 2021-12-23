package com.xk.controller;

import com.xk.dao.UserDao;
import com.xk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/checkRegister")
public class CheckRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        UserDao userDao=new UserDao();
        System.out.println(username);
        User user=userDao.Login(username);
        PrintWriter out=resp.getWriter();

        if (user == null){
            out.print(true);
        }else {
            System.out.println(user);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            out.print(false);
        }
        out.close();

    }
}
