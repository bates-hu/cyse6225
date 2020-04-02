package com.csye6225.spring2020.courseservice.datamodel;


import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import java.io.InputStream;
import java.util.Properties;


public class DynamoDbConnector {

    private static AmazonDynamoDB dynamoDb;
    private static void init() {


        if (dynamoDb == null) {
            String env = "dev";

            try {
                InputStream inputStream = DynamoDbConnector.class.getResourceAsStream("/app.properties");
                Properties properties = new Properties();
                properties.load(inputStream);
                env = properties.getProperty("env");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ("pro".equals(env)) {
                // production
                System.out.println("use production dynamodb");
                dynamoDb = AmazonDynamoDBClientBuilder
                        .standard()
                        .build();
            } else {
                // local
                System.out.println("use local dynamodb");
                ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
                credentialsProvider.getCredentials();
                dynamoDb = AmazonDynamoDBClientBuilder
                        .standard()
                        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-east-1"))
                        .build();
            }

            System.out.println("I created the client");
        }

    }

    public static AmazonDynamoDB  getClient() {
        if (dynamoDb == null) {
            synchronized (DynamoDbConnector.class) {
                if (dynamoDb == null) {
                    init();
                }
            }
        }
        return dynamoDb;
    }
}
