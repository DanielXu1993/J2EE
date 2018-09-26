package cn.xyh.a_tx;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/xyh/a_tx/bean.xml");
        User user = new User();
        user.setUserName("测试");
        UserService service = (UserService) ac.getBean("userService");
        service.save(user);
    }
}
