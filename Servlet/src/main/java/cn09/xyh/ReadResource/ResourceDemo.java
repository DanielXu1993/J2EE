package cn09.xyh.ReadResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取db.properties文件
 */
@WebServlet(name = "resourceDemo", urlPatterns = "/resourceDemo")
public class ResourceDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println("user = " + user);
        System.out.println("password = " + password);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
