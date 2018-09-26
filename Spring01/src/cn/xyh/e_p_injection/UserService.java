package cn.xyh.e_p_injection;

public class UserService {
    private UserDao userDao;

    // IOC:对象的创建交给spring外部容器完成
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
