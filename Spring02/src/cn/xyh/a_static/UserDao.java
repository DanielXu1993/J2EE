package cn.xyh.a_static;

/**
 * 目标对象
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("-----保存数据-----");
    }
}
