package com.csye6225.spring2020.courseservice.datamodel;



public class Professor {
    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private String joiningDate;

    public Professor() {

    }

    public Professor(String firstName,
                     String lastName, String department, String joiningDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
}

