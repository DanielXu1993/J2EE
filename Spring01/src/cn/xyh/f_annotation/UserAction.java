package cn.xyh.f_annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userAction")
public class UserAction {
    @Resource(name = "userService")
    private UserService userService;

    public String execute() {
        userService.save();
        return null;
    }
}
