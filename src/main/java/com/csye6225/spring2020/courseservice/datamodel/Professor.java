package com.csye6225.spring2020.courseservice.datamodel;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Date;

@DynamoDBTable(tableName="Professor")
public class Professor extends IdObject{
    private String firstName;
    private String lastName;
    private String department;
    private Date joiningDate;

    public Professor() {

    }

    public Professor(String id, String firstName, String lastName, String department, Date joiningDate) {
        this.id = id;
        this.firstName = firstName;
        this.department = department;
        this.joiningDate = joiningDate;
        this.lastName = lastName;
    }

    @DynamoDBHashKey(attributeName = "id")
    @Override
    public String getId() {
        return id;
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

    @DynamoDBAttribute(attributeName="department")
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBAttribute(attributeName="joiningDate")
    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }


    @Override
    public String toString() {
        return "Professor{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }

}

