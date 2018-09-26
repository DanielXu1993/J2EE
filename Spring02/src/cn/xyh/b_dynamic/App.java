package cn.xyh.b_dynamic;

import org.junit.jupiter.api.Test;

public class App {
    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory(new UserDao());
        IUserDao userDao = (IUserDao) factory.getInstance();
        System.out.println(userDao.getClass());// class com.sun.proxy.$Proxy8
        userDao.save();
    }
}