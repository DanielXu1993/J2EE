package cn.xyh.a_static;

/**
 * 代理对象(静态代理)
 * 代理对象要与目标对象实现一样的接口
 */
public class UserDaoProxy implements IUserDao {
    // 管理一个目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();// 执行目标对象的方法
        System.out.println("提交事务");
    }
}
