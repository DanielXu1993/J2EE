package cn.xyh.springmvc.app10;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

// 继承AbstractCommandController控制器以实现将jsp页面中的参数封装到对象中
// AbstractCommandController间接的实现了Controller接口,因此默认的适配器能够适配它
@SuppressWarnings("deprecation")
public class EmpAction extends AbstractCommandController {
    // 提供一个默认的构造器并且指定要封装的对象的类型
    public EmpAction() {
        this.setCommandClass(Emp.class);
    }

    // 重写initBinder方法自定义类型转换器,用于时间格式的转换.(非抽象方法)
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(
                Date.class,//将接收的String类型转换成指定的目标类型
                // 自定义的转换规则
                new CustomDateEditor(
                        new SimpleDateFormat("yyyy-MM-dd"),//传入的字符串的格式
                        true // 该日期字段可以为空
                )
        );
    }

    @Override
    protected ModelAndView handle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object obj,// 表示封装后的实体
            BindException e //表示封装时产生的异常
    ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "增加员工成功");
        Emp emp = (Emp) obj;
        System.out.println(emp.getUsername() + ":" + emp.getGender() + ":" + emp.getHiredate().toString());
        modelAndView.addObject("emp", emp);
        modelAndView.setViewName("/jsp/success.jsp");
        return modelAndView;
    }
}
