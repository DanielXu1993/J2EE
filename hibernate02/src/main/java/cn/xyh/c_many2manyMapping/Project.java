package cn.xyh.c_many2manyMapping;

import java.util.HashSet;
import java.util.Set;

public class Project {
    private int pro_id;
    private String pro_name;
    private Set<Developer> developers = new HashSet<>();

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }
}
