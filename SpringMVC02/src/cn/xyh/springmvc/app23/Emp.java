package cn.xyh.springmvc.app23;

public class Emp {
    private String username;
    private Double salary;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "username='" + username + '\'' +
                ", salary=" + salary +
                '}';
    }
}
