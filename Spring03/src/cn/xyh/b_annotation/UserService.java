package cn.xyh.b_annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);// 第一次调用

        int i = 1 / 0; // 出现异常,整个保存的方法要求回滚

        userDao.save(user);// 第二次调用
    }
}
