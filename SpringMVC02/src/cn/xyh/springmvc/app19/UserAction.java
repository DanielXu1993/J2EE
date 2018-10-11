package cn.xyh.springmvc.app19;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserAction {
    @InitBinder// 自定义类型转换器
    public void initBinder(ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy" +
                "-MM-dd"), true));
    }

    /**
     * 通过POJO对象收集参数:
     * 页面中的name属性值必须是POJO中的实例变量名.
     * 此时可以在业务方法中的参数中获取参数值.
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, Model model) throws Exception {
        System.out.println("用户注册:" + user.toString());
        model.addAttribute("message", "用户" + user.getUsername() + "注册成功");
        return "/jsp/success.jsp";
    }
}
