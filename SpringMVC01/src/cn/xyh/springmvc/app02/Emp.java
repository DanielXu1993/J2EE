package cn.xyh.springmvc.app02;

import java.util.UUID;

public class Emp {
    private String id;
    private String username;
    private double salary;

    public Emp() {
    }

    public Emp(String username, double salary) {
        this.username = username;
        this.salary = salary;
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
