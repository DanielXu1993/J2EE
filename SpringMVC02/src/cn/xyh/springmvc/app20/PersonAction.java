package cn.xyh.springmvc.app20;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/person")
public class PersonAction {
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy" +
                "-MM-dd"), true));
    }

    // 获取的参数的name属性值始终是方法参数中的实例变量
    @RequestMapping(value = "/register")
    public String register(Bean bean, Model model) throws Exception {
        System.out.println("普通用户: " + bean.getUser());
        System.out.println("管理员用户: " + bean.getAdmin());
        model.addAttribute("user", bean.getUser());
        model.addAttribute("admin", bean.getAdmin());
        return "/20_person.jsp";
    }
}
