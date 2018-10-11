package cn.xyh.springmvc.app15;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("message", "注册成功");
        return "/jsp/success.jsp";
    }

    @RequestMapping("/login") // 存在相同的路径会报错
    public String login(Model model) {
        model.addAttribute("message", "登录成功");
        return "/jsp/success.jsp";
    }
}
