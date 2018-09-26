package cn.xyh.a_tx;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        userDao.save(user);// 第一次调用

        int i = 1 / 0; // 出现异常,整个保存的方法要求回滚

        userDao.save(user);// 第二次调用
    }
}
