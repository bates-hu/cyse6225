package com.csye6225.spring2020.courseservice.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class IdObject {
    String id;

    IdObject() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
