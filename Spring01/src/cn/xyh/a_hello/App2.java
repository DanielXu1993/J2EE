package cn.xyh.a_hello;

/**
 * 1. 创建对象: 通过IOC创建的对象默认是单例的,可以通过scope属性进行设置.
 * scope = "Singleton" 单例,默认
 * scope = "prototype" 多例
 * 2. 对象创建的时机:
 * scope = "Singleton" : 默认在IOC容器创建之前创建对象
 * scope = "prototype" : 在使用到对象时进行创建
 * 3. 延迟创建: 单例的对象可以设置延迟创建(在第一次使用对象时创建.多例不存在延迟创建)
 * 属性:
 * lazy-init="false" 默认不延迟创建
 * lazy-init="true"  延迟创建
 */
public class App2 {
}
