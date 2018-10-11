package cn.xyh.springmvc.app23;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/emp")
public class EmpAction {
    @RequestMapping(value = "/addAll")
    public String addAll(Bean bean, Model model) throws Exception {
        for (Emp emp : bean.getEmpList()) {
            System.out.println(emp);
        }
        model.addAttribute("message", "批量添加员工成功");
        return "/jsp/success.jsp";
    }
}
