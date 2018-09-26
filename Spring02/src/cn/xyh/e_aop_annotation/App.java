package cn.xyh.e_aop_annotation;
/**
 * AOP (Aspect Oriented Programming)面向切面编程
 * 实现"业务代码"与"关注点代码"分离
 * "关注点代码"是指重复执行的代码
 * 关注点:重复的代码就叫关注点
 * 切面:关注点形成的类就叫切面(类)
 * 切入点:目标对象的方法
 * 可以通过切入点表达式执行拦截哪些类的哪些方法,从而植入切面类代码
 * 面向切面编程就是指对很多功能都有重复的代码进行抽取然后再在运行时往业务方法中动态的植入"切面类代码"
 * 如果目标类实现了接口,则spring框架选择JDK代理模式
 * 如果目标类没有实现接口,则spring框架选择cglib代理
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext(
            "cn/xyh/e_aop_annotation/bean.xml");

    @Test
    public void test() {
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.save();
        // class cn.xyh.e_aop_annotation.UserDao01$$EnhancerBySpringCGLIB$$9dd0ac2e
        System.out.println(userDao.getClass());
    }
}