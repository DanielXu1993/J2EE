package cn.xyh.emp.action;

import cn.xyh.emp.entity.Emp;
import cn.xyh.emp.service.EmpService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
@SuppressWarnings("deprecation")
public class EmpAction extends AbstractCommandController {

    private EmpService empService;

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    public EmpAction() {
        this.setCommandClass(Emp.class);
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    @Override
    protected ModelAndView handle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            BindException e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Emp emp = (Emp) o;
        System.out.println(emp.getHiredate().toString());
        empService.register(emp);
        modelAndView.addObject("message", "操作成功");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
