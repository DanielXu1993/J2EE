package cn.xyh.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * 测试hibernate常用API
 */
public class App2 {
    private static SessionFactory sessionFactory;

    /**
     *  主配置文件以及session工厂只需要加载一次
     */
    static {
        /**
         // 1. 创建配置管理类对象
         Configuration cfg = new Configuration();
         // 2. 加载配置文件
         cfg.configure(); // 加载src/hibernate.cfg.xml文件
         // cfg.configure("hibernate.cfg.xml"); // 加载指定路径下指定的文件

         // 3. 根据加载的配置管理类对象，创建sessionFactory对象
         sessionFactory = cfg.buildSessionFactory();
         // configure 对象代表的是主配置文件
         // sessionFactory对象代表的是主配置文件中的<session-factory>标签
         */
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // 保存对象
    @Test
    public void testSave() {
        // 创建要保存的对象
        Employee emp = new Employee();
        emp.setEmpName("张三");
        emp.setWorkDate(new Date());
        // 根据session工厂创建session对象
        Session session = sessionFactory.openSession();
        // 开启事务
        // hibernate要求所有修改数据库的操作必须在事务开启的环境中，否则不会执行操作
        Transaction transaction = session.beginTransaction();
        // -------执行操作---------
        session.save(emp);
        // 提交事务
        transaction.commit();
        // 关闭session
        session.close();
    }

    // 根据主键查询数据
    @Test
    public void testQuery() {
        Session session = sessionFactory.openSession();
        // 根据主键查询数据
        // get和load方法都能根据主键查询数据，当主键不存在时，get方法返回null而load方法报错
        // load方法支持懒加载
        Employee employee = session.get(Employee.class, 1);
        //Employee employee = session.load(Employee.class, 1);

        System.out.println(employee);
        session.close();
    }

    // 更新操作1:update方法
    @Test
    public void testUpdate1() {
        Employee emp = new Employee();
        emp.setEmpId(1);
        emp.setEmpName("李四");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // update方法的原理是以主键创建一个新的对象覆盖之前的数据
        // 如果提供的主键不存在或没有提供主键则报错
        // 对象要提供所有的字段值，没有提供的字段值则为空(数据库中主键为1的workDate为null)
        session.update(emp);
        transaction.commit();
        session.close();
    }

    // 更新操作2:saveOrUpdate方法
    @Test
    public void testUpdate2() {
        Employee emp = new Employee();
        emp.setEmpId(2);
        emp.setEmpName("李四");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 没有设置主键则执行保存操作，设置存在的主键则执行更新操作，设置的主键不存在则报错
        session.saveOrUpdate(emp);
        transaction.commit();
        session.close();
    }
}
