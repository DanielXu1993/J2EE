package cn12.xyh.Listener;

/**
 * 监听器： 主要是用来监听特定对象的创建或销毁、属性的变化的！
 * 是一个实现特定接口的普通java类！
 * <p>
 * 对象：别人创建自己用 （需要监听）
 * <p>
 * Servlet中哪些对象需要监听？
 * ----> request / session / servletContext
 * -------->分别对应的是request监听器、session相关监听器、servletContext监听器
 * 监听器接口：
 * 一、监听对象创建/销毁的监听器接口
 * Interface ServletRequestListener     监听request对象的创建或销毁
 * Interface HttpSessionListener        监听session对象的创建或销毁
 * Interface ServletContextListener     监听servletContext对象的创建或销毁
 * 二、监听对象属性的变化
 * Interface ServletRequestAttributeListener 监听request对象属性变化: 添加、移除、修改
 * Interface HttpSessionAttributeListener    监听session对象属性变化: 添加、移除、修改
 * Interface ServletContextAttributeListener  监听servletContext对象属性变化
 * <p>
 * 三、session相关监听器
 * Interface HttpSessionBindingListener   监听对象绑定到session上的事件
 * Interface HttpSessionActivationListener(了解) 监听session序列化及反序列化的事件
 * <p>
 * 监听器开发步骤：
 * 1.写一个普通java类，实现相关接口；
 * 2.配置(web.xml)
 */
public class Demo1 {
}
