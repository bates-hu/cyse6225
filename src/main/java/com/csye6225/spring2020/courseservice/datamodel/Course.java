package com.csye6225.spring2020.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Set;

@DynamoDBTable(tableName="Course")
public class Course extends IdObject{
    private String boardId;
    private String professorId;
    private String taId;
    private Set<String> enrolledStudents;
    private String department;

    public Course() {}

    public Course(String id, String boardId, String professorId, String taId, Set<String> enrolledStudents, String department) {
        this.id = id;
        this.boardId = boardId;
        this.professorId = professorId;
        this.taId = taId;
        this.enrolledStudents = enrolledStudents;
        this.department = department;
    }

    @DynamoDBHashKey(attributeName = "id")
    @Override
    public String getId() {
        return id;
    }


    @DynamoDBAttribute(attributeName="boardId")
    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @DynamoDBAttribute(attributeName="professorId")
    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    @DynamoDBAttribute(attributeName="taId")
    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }

    @DynamoDBAttribute(attributeName="enrolledStudents")
    public Set<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @DynamoDBAttribute(attributeName="department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", boardId='" + boardId + '\'' +
                ", professorId='" + professorId + '\'' +
                ", taId='" + taId + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                ", department='" + department + '\'' +
                '}';
    }
}
