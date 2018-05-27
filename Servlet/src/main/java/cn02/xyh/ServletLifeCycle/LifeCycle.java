package cn02.xyh.ServletLifeCycle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet生命周期方法：
 * 1.构造方法：创建servlet对象的时候调用。第一次访问servlet的时候调用，只调用一次。
 * 证明servlet对象在Tomcat中是单例的
 * 2.init方法：创建完servlet对象后调用，只调用一次
 * 3.service方法：每次发出请求时调用，调用n次
 * 4.destroy方法：销毁servlet对象时调用，只调用一次
 */
@WebServlet(urlPatterns = "/lifeCycle")
public class LifeCycle extends HttpServlet {

    /**
     * 1.构造方法
     */
    public LifeCycle() {
        System.out.println("1. servlet对象被创建了");
    }

    /**
     * 2.init方法
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2. init方法被调用了");
    }

    /**
     * 3.service方法
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        System.out.println("3. service方法被调用了");
    }

    /**
     * 4.destroy方法
     */
    @Override
    public void destroy() {
        System.out.println("4. servlet对象被销毁了");
    }
}
