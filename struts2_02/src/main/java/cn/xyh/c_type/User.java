package cn.xyh.c_type;

import java.util.Date;

public class User {
    private String name;
    private String pwd;
    private int age;
    private Date birth;

    public User() {
    }

    public User(String name, String pwd, int age, Date birth) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
