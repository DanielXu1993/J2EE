package cn.xyh.c_cglib;

import org.junit.jupiter.api.Test;

public class App {
    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory(new UserDao());
        UserDao proxyInstance = (UserDao) factory.getProxyInstance();
        // class cn.xyh.c_cglib.UserDao01$$EnhancerByCGLIB$$14db5d8f
        System.out.println(proxyInstance.getClass());
        proxyInstance.save();
    }
}