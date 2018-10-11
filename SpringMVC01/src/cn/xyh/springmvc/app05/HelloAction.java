package cn.xyh.springmvc.app05;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Spring MVC 中的控制器和处理器类
// 它是单例的,在第一次访问Spring MVC处理器时初始化所有的处理器类
public class HelloAction implements Controller {
    public HelloAction() {
        System.out.println("HelloAction()::" + this.hashCode());
    }

    // 业务方法
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        // ModelAndView表示向视图封装的数据和跳转的路径
        ModelAndView modelAndView = new ModelAndView();
        // 向视图添加数据
        modelAndView.addObject("message", "这是我的第一个Spring MVC 程序");
        // 设置跳转的路径
        modelAndView.setViewName("/jsp/success.jsp");
        return modelAndView;
    }
}
