package cn03.xyh.Init;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(urlPatterns = "/initDemo")
public class InitDemo extends HttpServlet {
    /**
     * 有参的init方法
     * 该方法是servlet的生命周期方法，一定会被Tomcat服务器调用
     * 如果要编写初始化的逻辑，不需要覆盖有参的init方法
     */
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//    }


    /**
     * 无参的init方法
     * 该方法是servlet的编写初始化代码的方法。该方法被设计用来专门被开发者覆盖，在里面编写初始化逻辑
     */
    @Override
    public void init() throws ServletException {
        System.out.println("无参的init方法");
    }
}
