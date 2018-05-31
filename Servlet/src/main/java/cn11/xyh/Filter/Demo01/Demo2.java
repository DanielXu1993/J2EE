package cn11.xyh.Filter.Demo01;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器执行流程：
 * -->1. 服务器启动，创建Filter实例，执行init方法
 * -->2. 用户请求Servlet/jsp
 * -->3. 第一个过滤器拦截，执行第一个过滤器doFiler方法
 * -->4. 第一个过滤器放行，chain.doFilter方法
 * -->5. 第二个过滤器拦截，执行第二个过滤器
 * -->6. 第二个过滤器chain.doFilter放行，执行Servlet/jsp
 * -->7. 执行完毕，返回第二个Filer，再返回第一个过滤器(chain.doFilter方法之后的操作)
 * -->8. 服务器关闭，执行所有的destroy方法
 */
// 第二个过滤器
@WebFilter(urlPatterns = "/*", filterName = "demo2")
public class Demo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第二个过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("第二个过滤器执行完毕");
    }

    @Override
    public void destroy() {

    }
}
