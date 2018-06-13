package cn.xyh.c_type;

/**
 * Struts核心业务：请求数据自动封装以及类型装换
 * 方式一：jsp表单数据填充到action中的对象的属性中
 */
public class UserAction2 {
    // 封装请求数据到对象的属性中 必须给set
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String register2() {
        System.out.println(user.getName());
        System.out.println(user.getPwd());
        System.out.println(user.getAge());
        System.out.println(user.getBirth());
        return "success";
    }
}
