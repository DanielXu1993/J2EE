package cn.xyh.c_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理
 * 在内存中构建一个代理子类对象
 */
public class ProxyFactory implements MethodInterceptor {
    // 管理一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance() {
        // 1. 工具类
        Enhancer en = new Enhancer();
        // 2. 设置代理对象的父类为目标对象
        en.setSuperclass(target.getClass());
        // 3.设置回调函数 (MethodInterceptor)
        en.setCallback(this);
        // 4. 创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");
        // 执行目标函数中的方法
        Object returnValue = method.invoke(target,objects);
        System.out.println("提交事务...");
        return returnValue;
    }
}
