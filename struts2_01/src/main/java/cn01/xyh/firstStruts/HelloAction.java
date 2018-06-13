package cn01.xyh.firstStruts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2开发步骤：
 * 1. 引入jar文件
 * 2. 配置web.xml：核心过滤器org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter
 * 3. 开发action类，一般继承ActionSupport
 * 4. action中的业务方法处理具体的请求
 * 5. 方法不能有参数，返回值类型为String
 * 6. 配置struts.xml
 */

/**
 * Struts2执行流程：
 * -->服务器启动时：
 * 1.加载web.xml
 * 2.创建Struts核心过滤器对象，执行filter的init方法
 * struts-default.xml  核心功能的初始化
 * struts-plugin.xml   struts相关插件
 * struts.xml          用户编写的配置文件
 * <p>
 * -->访问时：
 * 3. 用户访问Action，服务器根据访问的路径名称找到对应的action配置，创建action对象
 * 4. 执行默认拦截器栈中定义的18个拦截器
 * 5. 执行action中的业务处理方法
 * 6. 后面每次访问都会创建action实例
 */
public class HelloAction extends ActionSupport {
    // 每次请求都会重新创建Action实例，线程安全
    public HelloAction() {
        System.out.println("创建Action实例...");
    }

    public String hello() throws Exception {
        System.out.println("访问到了action，正在处理请求");
        return "success";
    }
}
