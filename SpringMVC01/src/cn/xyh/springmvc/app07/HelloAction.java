package cn.xyh.springmvc.app07;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction implements Controller {
    // 业务方法
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        // ModelAndView表示向视图封装的数据和跳转的路径
        ModelAndView modelAndView = new ModelAndView();
        // 向视图添加数据
        modelAndView.addObject("message", "这是我的第二个Spring MVC 程序,视图使用逻辑名");
        // 设置跳转的路径
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
