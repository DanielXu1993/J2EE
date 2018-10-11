package cn.xyh.springmvc.app09;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器是实现Controller接口的类
 */
public class UserAction implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println("员工姓名: " + username);
        modelAndView.addObject("message", username);
        modelAndView.setViewName("/jsp/success.jsp");
        return modelAndView;
    }
}
