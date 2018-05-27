package cn06.xyh.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 域对象：用于保存数据、获取数据。可以在不同的动态资源之间共享数据
 * ServletContext是一个域对象
 * 所有域对象：
 * 1. HttpServletRequet 域对象
 * 2. ServletContext域对象
 * 3. HttpSession 域对象
 * 4. PageContext域对象
 * <p>
 * 保存数据：void setAttribute(String name,Object object)
 * 获取数据：Object getAttribute(String name)
 * 删除数据：void removeAttribute(String name)
 */
@WebServlet(name = "contextDemo2", urlPatterns = "/contextDemo2")
public class ContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        /**
         * 在此servlet中把数据保存到域对象中，在ContextDemo3中取数据
         */
        ServletContext context = this.getServletContext();
        context.setAttribute("name", "eric");
        Student student = new Student("jacky", 20);
        context.setAttribute("student", student);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}