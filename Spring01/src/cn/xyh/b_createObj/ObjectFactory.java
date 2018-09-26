package cn.xyh.b_createObj;

public class ObjectFactory {
    public User getInstance() {
        return new User(100, "调用工厂的实例方法创建对象");
    }

    public static User getStaticInstance() {
        return new User(101, "调用工厂的静态方法创建对象");
    }
}
