package cn.xyh.springmvc.app23;

import java.util.ArrayList;
import java.util.List;

public class Bean {
    private List<Emp> empList = new ArrayList<>();

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}
