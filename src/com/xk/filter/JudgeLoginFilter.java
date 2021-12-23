package com.xk.filter;

import com.xk.dao.UserDao;
import com.xk.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class JudgeLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        User user= (User) request.getSession().getAttribute("user");
        String uri=request.getRequestURI();
        if (uri.endsWith("login") || uri.endsWith("register") || uri.endsWith(".jsp") ||
                uri.endsWith("registerView") || uri.endsWith("iflogin") || uri.endsWith(".css")
                || uri.endsWith(".js") || uri.endsWith("test") || uri.endsWith("checkRegister")
                || uri.endsWith("selectcodeimg") || uri.endsWith("getSession")){

            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if (user != null){

                filterChain.doFilter(servletRequest,servletResponse);

            }else {

                Cookie[] cookies=request.getCookies();
                if (cookies != null){
                    boolean isLogin=false;
                    for (Cookie cookie:cookies
                         ) {
                        if (cookie.getName().equals("username")){
                            String username=cookie.getValue();
                            UserDao userDao=new UserDao();
                            User user1=userDao.Login(username);
                            if (user1 != null){
                                isLogin=true;
                                HttpSession session=request.getSession();
                                session.setAttribute("user",user1);
                                filterChain.doFilter(servletRequest,servletResponse);
                            }
                        }
                    }
                    if (isLogin != true){
                        response.sendRedirect("login");
                    }

                }else {
                    response.sendRedirect("login");
                }

            }
        }
    }
}
