package cn.xyh.c_many2manyMapping;

import java.util.HashSet;
import java.util.Set;

public class Developer {
    private int d_id;
    private String d_name;
    private Set<Project> projects = new HashSet<>();

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
