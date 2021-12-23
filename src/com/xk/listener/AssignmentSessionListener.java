package com.xk.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class AssignmentSessionListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session添加了属性");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session移除了属性");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session替换了属性");
    }
}
