package cn.xyh.f_annotation;

import org.springframework.stereotype.Component;

// 把当前对象以id为"userDao"加入到IOC容器中
// 等价于配置[<bean id = "userDao" class = "...">]
@Component("userDao")
public class UserDao {
    public void save() {
        System.out.println("DB:保存用户");
    }
}
