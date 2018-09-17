package cn.xyh.a_hello;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class App3 {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * 测试HQL查询
     * SQL查询的是表以及表中的字段，不区分大小写
     * HQL查询的是对象以及对象中的属性，区分大小写
     */
    @Test
    public void testHQL() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Employee where empId = 5 or empId = 6");
        List<Employee> list = query.list();
        System.out.println(list);
        session.close();
    }

    /**
     * QBC查询，query by criteria 完全面向对象的查询
     */
    @Test
    public void testQBC() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class);
        // 查询条件
        criteria.add(Restrictions.eq("empId", 5));
        // 查询条件下的所有
        List<Employee> list = criteria.list();
        System.out.println(list);
        session.close();
    }

    /**
     * SQL查询：缺点,不支持跨数据库
     */
    @Test
    public void testSQL() {
        Session session = sessionFactory.openSession();
        // 把每一行记录封装成对象数组再添加到list集合中
        SQLQuery sqlQuery = session.createSQLQuery("select * from employee");
        // 把每一行数据按照指定的对象类型进行封装
        sqlQuery.addEntity(Employee.class);
        List<Employee> list = sqlQuery.list();
        System.out.println(list);
        session.close();
    }
}
