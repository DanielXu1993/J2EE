package cn12.xyh.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {
    // 对象销毁
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request对象销毁");
        Object obj = servletRequestEvent.getServletRequest().getAttribute("cn");
        System.out.println(obj); // China
    }

    // 对象创建
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request对象创建");
        Object obj = servletRequestEvent.getServletRequest().getAttribute("cn");
        System.out.println(obj); // null
    }
}
