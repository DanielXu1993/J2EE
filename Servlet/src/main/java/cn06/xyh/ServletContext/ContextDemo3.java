package cn06.xyh.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contextDemo3", urlPatterns = "/contextDemo3")
public class ContextDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        /**
         * 从域对象中取出数据
         */
        ServletContext context = this.getServletContext();
        String name = (String) context.getAttribute("name");
        System.out.println(name);
        Student student = (Student) context.getAttribute("student");
        System.out.println(student);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
