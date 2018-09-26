package cn.xyh.f_annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// 把当前对象加入到IOC容器中
@Component("userService")
public class UserService {
    // 从IOC容器中寻找id为"userDao"的对象并将其注入到当前字段
    // 等价于配置[<property name = "userDao" ref = "userDao">]
    @Resource(name = "userDao")
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
