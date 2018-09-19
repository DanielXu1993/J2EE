package cn.xyh.a_hqlQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

public class App {
    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * 主键查询
     */
    @Test
    public void testQueryAll() {
        Session session = factory.openSession();
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        System.out.println(emp.getDept().getDeptName());
        session.close();
    }

    /**
     * HQL查询所有列
     */
    @Test
    public void testHqlAll() {
        Session session = factory.openSession();
        Query q1 = session.createQuery("from Dept ");
        System.out.println(q1.list().get(0));

        Query q2 = session.createQuery("from Employee where empName = ?1 ");
        q2.setParameter(1, "张三");
        System.out.println(q2.uniqueResult());

        Query q3 = session.createQuery("from Dept where deptId between ?1 and ?2");
        q3.setParameter(1, 1);
        q3.setParameter(2, 10);
        System.out.println(q3.list());

        Query q4 = session.createQuery("from Dept  where deptName like ?1");
        q4.setParameter(1, "%事%");
        System.out.println(q4.uniqueResult());
        session.close();
    }

    /**
     * HQL聚合函数
     */
    @Test
    public void testHqlFunction() {
        Session session = factory.openSession();
        Query q1 = session.createQuery("select count(*) from Dept ");
        Long num = (Long) q1.uniqueResult();
        System.out.println(num);
        session.close();
    }

    /**
     * HQL分组查询
     */
    @Test
    public void testHqlGroup() {
        Session session = factory.openSession();
        Query q = session.createQuery("select e.dept, count(*) from Employee e group by e.dept");
        System.out.println(q.list());
        session.close();
    }

    /**
     * HQL连接查询
     */
    @Test
    public void testHqlJoin() {
        Session session = factory.openSession();
        // 1. 内连接 [映射文件中已经配置好了关系,关联的时候直接写对象的属性即可]
        Query q1 = session.createQuery("from Dept d inner join d.emps");
        // 结果集是一个Object[]数组集合,第一列为Dept对象,第二列是Employee对象.对象之间的数据没有实现填充
        System.out.println(q1.list());
        Object[] obj = (Object[]) q1.list().get(0);
        System.out.println(obj[0] + "===" + obj[1]);
        // 2. 左外连接
        Query q2 = session.createQuery("from Dept d left join d.emps");
        System.out.println(q2.list());
        session.close();

    }

    /**
     * HQL连接查询--迫切连接,将数据相互填充
     */
    @Test
    public void testHqlFetch() {
        Session session = factory.openSession();
        // 1. 迫切内连接 [使用fetch关键字,将右表中的数据填充到左表中]
        Query q1 = session.createQuery("from Dept d inner join fetch d.emps");
        // 结果集是一个Dept集合,并且将Employee数据填充到了对应的Dept中
        System.out.println(q1.list().get(0));
        // 2. 迫切右外连接
        Query q2 = session.createQuery("from Employee e right join fetch e.dept");
        System.out.println(q2.list());
        session.close();

    }

    /**
     * 将Hql语句存放在映射文件中并且读取执行
     */
    @Test
    public void testHqlTag() {
        Session session = factory.openSession();
        Query q = session.getNamedQuery("getAllDept");
        q.setParameter(1,2);
        System.out.println(q.list());
        session.close();

    }

    /**
     * 将Hql执行update语句
     */
    @Test
    public void testUpdate() {
        Session session = factory.openSession();
        session.beginTransaction();
        Query up = session.createQuery("update Employee set empName='张三33333' where empId = 1 ");
        up.executeUpdate();
        session.getTransaction().commit();
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        session.close();
    }
}