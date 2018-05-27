package cn04.xyh.ThreadSafe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet在Tomcat中是单实例多线程的
 * 每接收一个请求都会开启新的线程来处理它
 */
@WebServlet(urlPatterns = "/threadSafe")
public class ThreadSafe extends HttpServlet {
    // 案例：网站的第几位访客
    private int count = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        synchronized (ThreadSafe.class) {// 用锁来解决线程安全问题，锁对象必须唯一
            response.getWriter().write("你是第" + count + "个访客");//可能产生线程安全问题
            count++;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        this.doPost(req, resp);
    }
}
