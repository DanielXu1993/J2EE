package cn06.xyh.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ServletContext:
 * ServletContext对象表示当前web应用项目对象
 * 一个web可以对应多个servletConfig(一个servlet对应一个servletConfig对象)
 * 一个web应用程序只有一个servletContext
 * <p>
 * 创建时机：服务器加载web应用时创建对象
 * 获得对象：从servletConfig对象的getServletContext()方法获取
 * <p>
 * 常用API:
 * 1. String getContextPath()   --得到当前web应用的路径
 * <p>
 * 2. String getInitParameter(String name)  --得到web应用的初始化参数
 * 3. Enumeration getInitParameterNames()
 * <p>
 * 4. void setAttribute(String name, Object object) --域对象有关的方法
 * 5. Object getAttribute(String name)
 * 6. void removeAttribute(String name)
 * <p>
 * 7. RequestDispatcher getRequestDispatcher(String path)   --转发（类似于重定向）
 * 8. String getRealPath(String path)     --得到web应用的资源文件
 * 9. InputStream getResourceAsStream(String path)
 */
@WebServlet(name = "contextDemo", urlPatterns = "/contextDemo01")
public class ContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ServletContext context = this.getServletContext();
        /**
         * 1. 得到web应用路径:
         * 说白了就是部署到Tomcat服务器上运行web应用的名称
         */
        String contextPath = context.getContextPath();
        System.out.println(contextPath);// /servlet

        /**
         * 2. 得到web应用的初始化参数
         * 参数配置：在web.xml的根节点中配置
         * 注意：根据ServletContext的对象无法取到servletConfig中的参数
         * 因为servletConfig参数属于一个具体的servlet，只能由它的servlet获取
         */
        System.out.println(context.getInitParameter("AAA"));
        Enumeration<String> names = context.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + "==" + context.getInitParameter(name));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        this.doPost(req, resp);
    }
}
