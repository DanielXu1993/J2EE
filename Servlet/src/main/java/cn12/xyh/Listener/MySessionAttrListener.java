package cn12.xyh.Listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 监听session对象属性的变化
 */
@WebListener
public class MySessionAttrListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        Object obj = session.getAttribute("userName");
        System.out.println("添加的属性: " + obj);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
