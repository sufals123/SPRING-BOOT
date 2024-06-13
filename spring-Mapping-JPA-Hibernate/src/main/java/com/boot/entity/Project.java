package com.boot.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String projectName;

    @ManyToMany
    private Set<Emp> emps = new HashSet<>();

    // Constructors, getters, setters
    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    // Helper method to add emp to project
    public void addEmp(Emp emp) {
        emps.add(emp);
        emp.getProjects().add(this);
    }

    // Helper method to remove emp from project
    public void removeEmp(Emp emp) {
        emps.remove(emp);
        emp.getProjects().remove(this);
    }
}
