package cn.xyh.b_crud;

import cn.xyh.a_hello.Employee;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class App {
    IEmployeeDao dao = new EmployeeDao();

    @Test
    public void testSave() {
        Employee emp = new Employee("王五", new Date());
        dao.save(emp);
    }

    @Test
    public void testUpdate() {
        Employee emp = new Employee("赵六", new Date());
        emp.setEmpId(6);
        dao.update(emp);
    }

    @Test
    public void testFindById() {
        Employee employee = dao.findById(6);
        System.out.println(employee);
    }

    @Test
    public void testGetAll() {
        List<Employee> all = dao.getAll();
        System.out.println(all);
    }

    @Test
    public void testGetAllByName() {
        List<Employee> employees = dao.getAll("李四");
        System.out.println(employees);
    }

    @Test
    public void testDelete() {
        dao.delete(5);
    }
}
