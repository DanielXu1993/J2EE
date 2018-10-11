package cn.xyh.springmvc.app18;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserAction {
    @RequestMapping(value = "/register")
    // 也可以使用HttpSession对象
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("message", "使用HttpServletRequest对象传递值");
        // 传统方式转发,此时可以不用返回字符串转发(返回值类型为void),同时存在时启用上面的跳转
        // request.getRequestDispatcher("/jsp/ok.jsp").forward(request, response);
        // 重定向(转发后再重定向不会跳转)
        // response.sendRedirect("www.baidu.com");
        // 转发(推荐)
        return "/jsp/success.jsp";
    }
}
