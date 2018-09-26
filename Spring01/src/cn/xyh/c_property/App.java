package cn.xyh.c_property;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext(
            "cn/xyh/c_property/bean.xml");

    // 1.通过构造函数为属性注入值
    @Test
    public void testConstructorInjection() {
        User user = (User) ac.getBean("constructorInjection");
        System.out.println(user);
        //  -------有参构造器----------
        //  User{id=100, name='construction injection'}
    }

    // 2.通过set方法为属性注入值
    @Test
    public void testSetInjection() {
        User user = (User) ac.getBean("setInjection");
        System.out.println(user);
        // -------无参构造器----------
        // User{id=200, name='set injection'}
    }
}
