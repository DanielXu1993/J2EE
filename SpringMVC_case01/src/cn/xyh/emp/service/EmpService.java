package cn.xyh.emp.service;

import cn.xyh.emp.dao.EmpDao;
import cn.xyh.emp.entity.Emp;

public class EmpService {
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    public void register(Emp emp) throws Exception {
        empDao.add(emp);
    }
}
