package cn.xyh.springmvc.app14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //配置当前Action
//@RequestMapping("/")相当于命名空间,可省
public class HelloAction {
    public HelloAction() {
        // 单例
        System.out.println("HelloAction()::" + this.hashCode());
    }

    /**
     * 使用@RequestMapping修饰的方法为业务方法.
     * 注解@RequestMapping中的value值表示该业务方法处理的请求路径(命名空间+value),是个数组类型.后缀可省
     * 该业务方法表示只要是/hello.action的请求都交由该方法来处理
     *
     * @param model 用于数据的传递.相当于request域对象
     * @return 返回的字符串表示的是跳转的路径.
     */
    @RequestMapping(value = "/hello.action")
    public String hello(Model model) {
        System.out.println("HelloAction:::Hello");
        model.addAttribute("message", "这是我的第一个注解版的SpringMVC程序");
        return "success";
    }

    @RequestMapping(value = {"/bye", "/byebye"})
    public String bye(Model model) {
        model.addAttribute("message", "再见");
        return "success";
    }

}
