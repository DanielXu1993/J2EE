package cn.xyh.springmvc.app16;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserAction {
    // 收集普通参数时参数名要与界面中的name属性值保持一致,根据名称匹配而不是类型
    // 设置指定类型的请求需要配置@RequestMapping的method属性,默认可以接受POST和GET请求
    // 一下是设置只处理POST请求
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String username, String salary, Model model) {
        System.out.println(username + ":::" + salary);
        model.addAttribute("message", "用户注册成功");
        return "/jsp/success.jsp";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(String username, Model model) {
        System.out.println(username + ":::");
        model.addAttribute("message", "用户登录成功");
        return "/jsp/success.jsp";
    }
}
