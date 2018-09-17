package cn.xyh.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

public class App1 {
    @Test
    public void test() {
        // 要插入数据库的对象
        Employee emp = new Employee();
        emp.setEmpName("班长");
        emp.setWorkDate(new Date());

        // 获取加载配置文件的管理类对象
        Configuration config = new Configuration();
        config.configure(); // 默认加载src/hibernate.cfg.xml文件
        // 创建session工厂对象
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 创建session(代表一个与数据库的会话)
        Session session = sessionFactory.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        // 保存到数据库
        session.save(emp);
        // 提交事务
        transaction.commit();
        // 关闭资源
        session.close();
        sessionFactory.close();
    }
}
