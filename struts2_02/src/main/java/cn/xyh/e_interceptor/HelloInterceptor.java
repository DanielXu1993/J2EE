package cn.xyh.e_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自定义拦截器
 */
public class HelloInterceptor implements Interceptor {

    // 服务器启动时执行
    public HelloInterceptor() {
        System.out.println("创建了拦截器对象");
    }

    // 服务器启动时执行
    @Override
    public void init() {
        System.out.println("执行了拦截器的初始化方法");
    }

    // 拦截器业务处理方法
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("2. 执行Action之前");

        // 调用下一个拦截器或者执行Action(chain.doFilter)
        // 返回的是action中执行的方法的返回值
        String resultFlag = invocation.invoke();
        System.out.println(resultFlag);

        System.out.println("4. 拦截器业务处理结束");
        return resultFlag;
    }

    @Override
    public void destroy() {
        System.out.println("销毁。。。");
    }
}
