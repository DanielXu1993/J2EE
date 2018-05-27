package cn07.xyh.ServletForward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet(name = "redirectDemo1", urlPatterns = "/redirectDemo1")
public class RedirectDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // response.sendRedirect("/servlet/index.html");
        // response.sendRedirect("http://www.baidu.com");
        request.setAttribute("name","jack");
        response.sendRedirect("/servlet/getData");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
