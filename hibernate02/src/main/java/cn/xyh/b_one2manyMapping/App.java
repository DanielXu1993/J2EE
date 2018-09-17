package cn.xyh.b_one2manyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class App {
    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    // 从部门方保存数据【从多的一方操作】
    @Test
    public void testSave1() {
        Session session = factory.openSession();
        session.beginTransaction();

        Dept dept = new Dept();
        dept.setDeptName("开发部");

        Employee emp1 = new Employee();
        emp1.setEmpName("张三1");
        Employee emp2 = new Employee();
        emp2.setEmpName("张三2");
        Set<Employee> set = new HashSet<>();
        set.add(emp1);
        set.add(emp2);
        dept.setEmps(set);

        session.save(emp1);
        session.save(emp2);
        session.save(dept);

        session.getTransaction().commit();
        session.close();
    }

    // 从员工方保存数据【从一的一方操作】推荐
    @Test
    public void testSave2() {
        Session session = factory.openSession();
        session.beginTransaction();

        Dept dept = new Dept();
        dept.setDeptName("人事部");

        Employee emp1 = new Employee();
        emp1.setEmpName("李四1");
        emp1.setDept(dept);
        Employee emp2 = new Employee();
        emp2.setEmpName("李四2");
        emp2.setDept(dept);

        session.save(dept); // 先保存一的一方，效率高
        session.save(emp1);
        session.save(emp2);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGet() {
        Session session = factory.openSession();
        // 通过部门获取所有员工
        //Dept dept = session.get(Dept.class, 1);
        //System.out.println(dept.getDeptId());
        //System.out.println(dept.getDeptName());
        //System.out.println(dept.getEmps());// 懒加载

        // 通过员工获取其所在的部门
        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee.getEmpId());
        System.out.println(employee.getEmpName());
        System.out.println(employee.getDept().getDeptName()); // 懒加载
        session.close();
    }
}
