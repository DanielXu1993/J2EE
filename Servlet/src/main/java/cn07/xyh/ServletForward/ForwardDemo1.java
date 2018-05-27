package cn07.xyh.ServletForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发与重定向的区别：
 * 1. 转发的地址栏不会改变，重定向的地址栏会变成重定向到的地址
 * 2. 转发只能跳转到当前web应用内的资源，重定向可以跳转到任意资源，包括外部资源
 * 3. 可以在转发过程中把数据保存到request域对象中，重定向不能在request域对象中保存数据
 */


/**
 * 转发
 */
@WebServlet(name = "forwardDemo1", urlPatterns = "/forwardDemo1")
public class ForwardDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // RequestDispatcher rd = request.getRequestDispatcher("/index.html");
        request.setAttribute("name", "rose");
        RequestDispatcher rd = request.getRequestDispatcher("/getData");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
