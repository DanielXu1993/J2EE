package cn.xyh.b_createObj;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext(
            "cn/xyh/b_createObj/bean.xml");

    // 1. 默认调用无参构造器创建对象
    @Test
    public void testDefaultCreation() {
        ac.getBean("defaultUser");
    }

    // 2.1 调用带参构造器创建对象1
    @Test
    public void testWithParaCreation1() {
        User user = (User) ac.getBean("withParaUser1");
        System.out.println(user);
    }

    // 2.1 调用带参构造器创建对象2
    @Test
    public void testWithParaCreation2() {
        User user = (User) ac.getBean("withParaUser2");
        System.out.println(user);
    }

    /**
     * 通过工厂类的实例方法创建对象
     */
    @Test
    public void testInstanceObj() {
        User user = (User) ac.getBean("instanceObj");
        System.out.println(user);
    }

    /**
     * 通过工厂类的静态方法创建对象
     */
    @Test
    public void testStaticObj() {
        User user = (User) ac.getBean("staticObj");
        System.out.println(user);
    }
}
