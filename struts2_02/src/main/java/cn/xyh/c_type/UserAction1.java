package cn.xyh.c_type;

import java.util.Date;

/**
 * Struts核心业务：请求数据自动封装以及类型装换
 *  方式一：jsp表单数据填充到action中的属性
 */
public class UserAction1 {
    // 封装请求数据 必须给set
    private String name;
    private String pwd;
    private int age;
    private Date birth;

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String register1() {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(age);
        System.out.println(birth);
        return "success";
    }
}
