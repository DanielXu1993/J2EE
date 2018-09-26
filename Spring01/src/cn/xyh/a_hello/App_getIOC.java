package cn.xyh.a_hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App_getIOC {

    // 1. 通过工厂类获取IOC容器对象(已过时)
    @Test
    public void test1() {
        // 将配置文件作为资源导入
        Resource resource = new ClassPathResource("cn/xyh/a_hello/bean.xml");
        // 根据资源文件创建BeanFactory
        BeanFactory factory = new XmlBeanFactory(resource);
        // 根据配置文件中bean节点的id属性获取对象
        User user = (User) factory.getBean("user");
        System.out.println(user);
    }

    // 2. 直接获取对象(常用)
    @Test
    public void test2() {
        // 直接获取IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/a_hello/bean.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
