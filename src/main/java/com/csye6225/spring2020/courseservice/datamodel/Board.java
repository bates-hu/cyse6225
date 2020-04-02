package com.csye6225.spring2020.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Board")
public class Board extends IdObject{
    private String courseId;

    public Board() {}

    public Board(String id, String courseId) {
        this.id = id;
        this.courseId = courseId;
    }

    @DynamoDBHashKey(attributeName = "id")
    @Override
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName="courseId")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
