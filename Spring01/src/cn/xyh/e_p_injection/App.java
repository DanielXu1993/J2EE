package cn.xyh.e_p_injection;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ApplicationContext ac = new ClassPathXmlApplicationContext(
            "cn/xyh/e_p_injection/bean.xml");

    @Test
    public void test() {
        UserAction ua = (UserAction) ac.getBean("userAction");
        ua.execute();
        // DB:保存用户
    }

}
