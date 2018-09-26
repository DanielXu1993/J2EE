package cn.xyh.d_myaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/d_myaop/bean.xml");

    @Test
    public void test() {
        ProxyFactory factory = (ProxyFactory) ac.getBean("proxyFactory");
        UserDao proxyInstance = (UserDao) factory.getProxyInstance();
        proxyInstance.save();
    }
}