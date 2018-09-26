package cn.xyh.g_annotation2;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

// @Component("userAction")等价于
//@Component等价于
@Controller
public class UserAction {
    //@Resource(name = "userService")
    @Resource
    private UserService userService;

    public String execute() {
        userService.save();
        return null;
    }
}
