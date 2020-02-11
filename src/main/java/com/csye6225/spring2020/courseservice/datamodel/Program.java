package com.csye6225.spring2020.courseservice.datamodel;


import java.util.List;

public class Program {
    private Long id;
    private String name;
    private List<Long> courses;

    public Program(){}

    public Program(String name, List<Long> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }
}
