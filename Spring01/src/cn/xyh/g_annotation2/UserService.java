package cn.xyh.g_annotation2;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component("userService")等价于
//@Component等价于
@Service
public class UserService {

    //@Resource(name = "userDao")等价于
    @Resource // 在IOC容器中根据类型查找
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
