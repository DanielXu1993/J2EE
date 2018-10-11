package cn.xyh.springmvc.app24;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/emp")
public class EmpAction {
    @RequestMapping(value = "/find")
    public String findEmpById(int id) throws Exception {
        System.out.println("查询" + id + "号员工信息");
        // 转发到另一个业务方法中处理
        return "forward:/emp/update.action";
        // 转发到另一个业务方法中处理
        //return "redirect:/emp/update.action?id=" + id;
    }

    @RequestMapping(value = "/update")
    public String findEmpById(int id, Model model) throws Exception {
        System.out.println("更新" + id + "号员工信息");
        return "/jsp/success.jsp";
    }

}
