package cn.xyh.a_static;

import org.junit.jupiter.api.Test;

public class App {
    @Test
    public void test() {
        IUserDao target = new UserDao(); // 目标对象

        IUserDao proxy = new UserDaoProxy(target); // 代理对象
        System.out.println(proxy.getClass());// class cn.xyh.a_static.UserDaoProxy
        proxy.save(); // 执行的是代理对象中的方法
    }
}