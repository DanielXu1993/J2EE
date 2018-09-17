package cn.xyh.a_hello;

import java.util.Date;

public class Employee {
    private int empId;
    private String empName;
    private Date workDate;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Employee(int empId, String empName, Date workDate) {

        this.empId = empId;
        this.empName = empName;
        this.workDate = workDate;
    }

    public Employee() {

    }

    public Employee(String empName, Date workDate) {
        this.empName = empName;
        this.workDate = workDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", workDate=" + workDate +
                '}';
    }
}
