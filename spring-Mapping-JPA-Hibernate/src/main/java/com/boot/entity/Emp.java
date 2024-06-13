package com.boot.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "emps", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<Project> projects = new HashSet<>();

    // Constructors, getters, setters
    public Emp() {
    }

    public Emp(String name) {
        this.name = name;
    }

    // Getters and setters
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    // Helper method to add project to emp
    public void addProject(Project project) {
        projects.add(project);
        project.getEmps().add(this);
    }

    // Helper method to remove project from emp
    public void removeProject(Project project) {
        projects.remove(project);
        project.getEmps().remove(this);
    }
}
