package com.csye6225.spring2020.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;
import java.util.Set;

@DynamoDBTable(tableName="Student")
public class Student extends IdObject{
    private String firstName;
    private String lastName;
    private Date joiningDate;
    private String department;
    private Set<String> registeredCourses;

    public Student() {}

    public Student(String id, String firstName, String lastName, Date joiningDate, String department, Set<String> registeredCourses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joiningDate = joiningDate;
        this.department = department;
        this.registeredCourses = registeredCourses;
    }

    @DynamoDBHashKey(attributeName = "id")
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName="firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute(attributeName="lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBAttribute(attributeName="joiningDate")
    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @DynamoDBAttribute(attributeName="department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBAttribute(attributeName="registeredCourses")
    public Set<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(Set<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joiningDate=" + joiningDate +
                ", department='" + department + '\'' +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}
