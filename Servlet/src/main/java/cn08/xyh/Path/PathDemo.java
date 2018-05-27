package cn08.xyh.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * web应用中的路径问题:
 * 在路径中以 / 开头会有两种定位：
 * 1. 如果该动作由服务器完成，则 / 表示在WebRoot(web)文件夹下
 * 2. 如果该动作由浏览器完成，则 / 表示在Tomcat服务器的webapps文件夹下
 */
@WebServlet(name = "pathDemo", urlPatterns = "/pathDemo")
public class PathDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /**
         * 1. 转发：服务器行为
         */
        request.getRequestDispatcher("/target.html").forward(request, response);
        /**
         * 2. 重定向:浏览器行为
         */
        response.sendRedirect(this.getServletContext().getContextPath() + "/target.html");
        /**
         * 3. html页面的超链接 :浏览器行为
         */
        response.getWriter().write("<html><body><a href = '/servlet/target.html'>超链接</a></body" +
                "></html>");

        /**
         * 4. html页面中的form提交的地址：浏览器行为
         */
        response.getWriter().write("<html><body><form action = '/servlet/target.html'><input type" +
                " = 'submit'/></form></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
