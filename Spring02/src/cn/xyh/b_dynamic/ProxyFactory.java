package cn.xyh.b_dynamic;

import java.lang.reflect.Proxy;

/**
 * 给所有的dao创建代理对象[动态代理]
 * 代理对象不需要实现接口
 * 目标对象必须要实现接口,否则会报错
 */
public class ProxyFactory {
    // 管理一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 根据目标对象生成代理对象
    public Object getInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开启事务");
                    // 执行目标对象的方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务");
                    return returnValue;
                }
        );
    }

}
