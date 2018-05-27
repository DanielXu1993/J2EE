package cn05.xyh.ServletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletConfig对象：
 * 主要是用于加载servlet的初始化参数
 * 创建时机：创建Servlet之后，调用init之前
 * ServletConfig的API：
 * 1. String getInitParameter(String name)  根据参数名获取参数值
 * 2. Enumeration getInitParameterNames()    获取所有参数名
 * 3. ServletContext getServletContext()     得到servlet上下文对象
 * 4. String getServletName()       得到servlet的名称
 */
public class ConfigDemo extends HttpServlet {
    /**
     * 根据web.xml中配置的路径将对应的文件的内容打印到网页上
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        String path = config.getInitParameter("path");
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        PrintWriter out = response.getWriter();
        while ((line = br.readLine()) != null) {
            out.println(line);
        }
        // 获取所有的参数名
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name + "==" + value);
        }
        // 获取Servlet名称
        System.out.println(config.getServletName());//configDemo
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        this.doPost(req, resp);
    }
}
