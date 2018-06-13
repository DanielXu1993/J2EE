package cn.xyh.a_config;

// 方式3,不继承或实现任何类或接口
public class UserAction3 {

    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Action 中业务处理方法
    public String login() {
        System.out.println("UserAction1.login()" + userName);
        return "success";
    }

    public String register() {
        System.out.println("UserAction1.register()" + userName);
        return "success";
    }
}
