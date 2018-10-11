package cn.xyh.emp.dao;

import cn.xyh.emp.entity.Emp;
import cn.xyh.emp.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Timestamp;

public class EmpDao {
    public void add(Emp emp) throws Exception {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = " insert into emps(id,username,salary,hiredate) values(?,?,?,?) ";
        Object[] params = {emp.getId(), emp.getUsername(), emp.getSalary(),
                new Timestamp(emp.getHiredate().getTime())};
        runner.update(sql, params);
    }
}
