package cn.xyh.a_config;

import com.opensymphony.xwork2.Action;

// 方式2,实现Action接口
public class UserAction2  implements Action {

    // Action 中业务处理方法
    public String login() {
        System.out.println("UserAction1.login()");
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }
}
