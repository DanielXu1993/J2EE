package cn.xyh.springmvc.app02;

public class EmpService {
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    public void addEmp(Emp emp) throws Exception {
        if (emp == null)
            throw new RuntimeException("用户不存在,添加失败");

        empDao.add(emp);
    }
}
