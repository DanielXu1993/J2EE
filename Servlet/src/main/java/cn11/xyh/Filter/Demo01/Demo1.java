package cn11.xyh.Filter.Demo01;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器必须实现javax.servlet.Filter接口,然后再web.xml中配置这个过滤器
 * 过滤器执行流程：
 * --> 1.用户访问服务器
 * --> 2.过滤器对Servlet请求进行拦截
 * --> 3.过滤器对请求进行处理
 * --> 4.处理完后放行请求，请求到达Servlet/jsp
 * --> 5.Servlet处理请求
 * --> 6.Servlet处理完后再回到过滤器，最后再由Tomcat服务器响应用户
 * --> 6.Servlet处理完后再回到过滤器，最后再由Tomcat服务器响应用户
 */
public class Demo1 implements Filter {

    public Demo1() {
        // 服务器启动时执行，只执行一次
        System.out.println("1.创建过滤器实例");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 服务器启动时执行，只执行一次
        System.out.println("2.执行过滤器初始化方法");
    }

    // 过滤器业务处理方法：在请求到达servlet之前进入此方法处理公共的业务逻辑操作
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.执行过滤器业务处理方法");

        // 放行，去到servlet或下一个过滤器
        filterChain.doFilter(request, response);

        System.out.println("5.servlet处理完，回到过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("6.销毁过滤器实例");
    }
}
