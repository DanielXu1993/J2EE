package cn.xyh.b_crud;

import cn.xyh.a_hello.Employee;

import java.io.Serializable;
import java.util.List;

public interface IEmployeeDao {
    void save(Employee emp);
    void update(Employee emp);
    Employee findById(Serializable id);
    List<Employee> getAll();
    List<Employee> getAll(String employeeName);
    void delete(Serializable id);
}
