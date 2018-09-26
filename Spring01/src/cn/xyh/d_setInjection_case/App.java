package cn.xyh.d_setInjection_case;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext(
            "cn/xyh/d_setInjection_case/bean.xml");

    @Test
    public void test() {
        UserAction ua = (UserAction) ac.getBean("userAction");
        ua.execute();
        // DB:保存用户
    }

    // 测试内部bean写法
    @Test
    public void testInnerBean() {
        UserAction ua = (UserAction) ac.getBean("userActionInner");
        ua.execute();
        // DB:保存用户
    }
}
