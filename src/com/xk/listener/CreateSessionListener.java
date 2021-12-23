package com.xk.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CreateSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session创建了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁了");
    }
}
