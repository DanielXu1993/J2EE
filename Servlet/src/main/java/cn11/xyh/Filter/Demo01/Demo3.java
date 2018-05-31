package cn11.xyh.Filter.Demo01;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * interface  Filter: 过滤器核心接口
 * --> 1. void  init(FilterConfig);初始化方法，在服务器启动时候执行
 * --> 2. void  doFilter(ServletRequest,ServletResponse,FilterChain);过滤器拦截的业务处理方法
 * --> 3. void destroy();销毁过滤器实例时候调用
 * <p>
 * interface  FilterConfig:获取初始化参数信息
 * --> 1. String	getInitParameter(String name)
 * --> 2. Enumeration	getInitParameterNames()
 * <p>
 * interface  FilterChain:过滤器链参数；一个个过滤器形成一个执行链；
 * --> void doFilter(ServletRequest request, ServletResponse response)执行下一个过滤器或Servlet/jsp
 */
public class Demo3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encode = filterConfig.getInitParameter("encoding");
        System.out.println(encode);

        Enumeration<String> names = filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + " == " + filterConfig.getInitParameter(name));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
