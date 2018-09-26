package cn.xyh.g_annotation2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解的方式为属性注入值
 */
public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext(
            "cn/xyh/g_annotation2/bean.xml");

    @Test
    public void test() {
        UserAction ua = (UserAction) ac.getBean("userAction");
        ua.execute();
        // DB:保存用户
    }

}
