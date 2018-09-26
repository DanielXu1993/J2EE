package cn.xyh.b_createObj;

public class User {
    private int id;
    private String name;

    public User() {
        System.out.println("-------无参构造器----------");
    }

    public User(int id, String name) {
        System.out.println("-------有参构造器----------");
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
