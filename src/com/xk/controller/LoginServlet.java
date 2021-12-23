package com.xk.controller;

import com.xk.dao.UserDao;
import com.xk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            String username=req.getParameter("username");
            String password=req.getParameter("password");

            User user=new UserDao().Login(username);

            if (user.getPassword()!= null && user.getPassword().equals(password)){
                HttpSession session=req.getSession();
                session.setAttribute("user",user);

                Cookie cookie=new Cookie("username",user.getUsername());
                cookie.setPath("/mvc");
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);

                resp.sendRedirect("select");
            }else {
                resp.sendRedirect("login");
            }
        }

}
