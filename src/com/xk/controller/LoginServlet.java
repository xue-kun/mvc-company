package com.xk.controller;

import com.xk.dao.UserDao;
import com.xk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    /*
    * 0表示登陆成功
    * 1表示用户名错误
    * 2表示密码错误
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            String username=req.getParameter("username");
            String password=req.getParameter("password");

            User user=new UserDao().Login(username);
            PrintWriter out = resp.getWriter();
            if (user == null){
                out.print(1);
            }else if (!user.getPassword().equals(password)){
                out.print(2);
            }else {
                HttpSession session=req.getSession();
                session.setAttribute("user",user);
                out.print(0);

                Cookie cookie=new Cookie("username",user.getUsername());
                cookie.setPath("/mvc");
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);

            }
            out.close();


            /*if (user != null && user.getPassword().equals(password)){
                HttpSession session=req.getSession();
                session.setAttribute("user",user);

                Cookie cookie=new Cookie("username",user.getUsername());
                cookie.setPath("/mvc");
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);

                resp.sendRedirect("select");
            }else {
                resp.sendRedirect("login");
            }*/
        }

}
