package cn.xyh.b_crud;

import cn.xyh.a_hello.Employee;
import cn.xyh.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    @Override
    public void save(Employee emp) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(emp);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Employee emp) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(emp);
        transaction.commit();
        session.close();
    }

    @Override
    public Employee findById(Serializable id) {
        Session session = HibernateUtils.getSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        Session session = HibernateUtils.getSession();

        Query query = session.createQuery("from Employee ");
        List<Employee> list = query.list();

        session.close();
        return list;
    }

    @Override
    public List<Employee> getAll(String employeeName) {
        Session session = HibernateUtils.getSession();

        Query query = session.createQuery("from Employee where empName = :name");
        query.setParameter("name", employeeName);
        List<Employee> list = query.list();

        session.close();
        return list;
    }

    @Override
    public void delete(Serializable id) {
        // 先根据id查询对象，如果非空则执行删除
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            // 防止id不存在报错
            session.delete(employee);
        }
        transaction.commit();
        session.close();
    }
}
