package cn.xyh.springmvc.app22;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping(value = "/emp")
public class EmpAction {
    @RequestMapping(value = "/deleteAll")
    public String deleteAll(int[] ids, Model model) throws Exception {
        System.out.println("需要删除的员工编号是: " + Arrays.toString(ids));
        model.addAttribute("message", "批量删除成功");
        return "/jsp/success.jsp";
    }
}
