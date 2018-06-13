package cn.xyh.a_config;

import com.opensymphony.xwork2.ActionSupport;
//如果要使用Struts的数据校验功能，就必须要继承ActionSupport
public class UserAction extends ActionSupport {

    // Action 中业务处理方法
    public String login() {
        System.out.println("UserAction1.login()");
        return SUCCESS;
    }
}
