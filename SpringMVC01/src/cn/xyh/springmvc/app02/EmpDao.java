package cn.xyh.springmvc.app02;

import org.apache.commons.dbutils.QueryRunner;

public class EmpDao {
    public void add(Emp emp) throws Exception {
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into emps(id,username,salary) values(?,?,?)";
        Object[] params = {emp.getId(), emp.getUsername(), emp.getSalary()};
        runner.update(sql, params);
    }
}
