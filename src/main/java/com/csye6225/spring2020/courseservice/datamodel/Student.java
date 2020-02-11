package com.csye6225.spring2020.courseservice.datamodel;

import java.util.List;


public class Student {
    private Long id;
    private String name;
    private String imageUrl;
    private List<Long> enrolledCourses;
    private Long program;

    public Student() {}

    public Student(String name, String imageUrl, Long program) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", enrolledCourses=" + enrolledCourses +
                ", program='" + program + '\'' +
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Long> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Long> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }
}
