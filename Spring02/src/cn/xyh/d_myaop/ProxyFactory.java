package cn.xyh.d_myaop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Component
public class ProxyFactory implements MethodInterceptor {
    @Resource
    private UserDao target;
    @Resource
    private Aop aop;

    public Object getProxyInstance() {
        this.aop = aop;
        this.target = target;
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        aop.begin();
        Object returnValue = method.invoke(target, objects);
        aop.commit();
        return returnValue;
    }
}
