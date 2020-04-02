package com.csye6225.spring2020.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.TransactionCanceledException;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.spring2020.courseservice.datamodel.IdObject;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestService<T extends IdObject> {
    DynamoDBMapper mapper;
    private Class<T> clazz;

    public RestService(Class<T> clazz) {
        mapper = new DynamoDBMapper(DynamoDbConnector.getClient());
        this.clazz = clazz;
    }

    public ResponseWrapper<List<T>> getAll() {
        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING)
                .build();
        List<T> ret = mapper.scan(clazz, new DynamoDBScanExpression(), config);
        return ResponseWrapper.ofSuc(ret);
    }

//    public ResponseWrapper<List<T>> getAllWithSingleFilter(String attrName, String targetAttr) {
//        HashMap<String, AttributeValue> eav = new HashMap<>();
//        eav.put(":v1", new AttributeValue().withS(targetAttr));
//
//        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
//                .withPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING)
//                .build();
//        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
//                .withFilterExpression(attrName + " = :v1")
//                .withExpressionAttributeValues(eav);
//
//        List<T> ret = mapper.scan(clazz, scanExpression, config);
//        return ResponseWrapper.ofSuc(ret);
//    }


    // map<AttrValue, attrName>
    public ResponseWrapper<List<T>> getAllWithMultipleFilter(Map<String ,String> filters) {
        if (filters.size() == 0) {
            return getAll();
        }
        HashMap<String, AttributeValue> eav = new HashMap<>();
        int i = 1;
        for (String key : filters.keySet()) {
            eav.put(":v" + i, new AttributeValue().withS(key));
            i++;
        }
        // build expression
        List<String> mid = eav.entrySet().stream()
                .map(entry -> String.format("%s = %s", filters.get(entry.getValue().getS()), entry.getKey()))
                .collect(Collectors.toList());

        String expressionStr = String.join(" and ", mid);

        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING)
                .build();
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression(expressionStr)
                .withExpressionAttributeValues(eav);

        List<T> ret = mapper.scan(clazz, scanExpression, config);
        return ResponseWrapper.ofSuc(ret);
    }

    public ResponseWrapper addWithUniqueID(T model) {
        TransactionWriteRequest transactionWriteRequest = new TransactionWriteRequest();
        transactionWriteRequest.addPut(model, new DynamoDBTransactionWriteExpression().withConditionExpression("attribute_not_exists(id)"));
        System.out.println(" the insert model "+ model);
        try {
            System.out.println("the request is \n " + transactionWriteRequest);
            mapper.transactionWrite(transactionWriteRequest);
            return ResponseWrapper.ofSuc();
        } catch (TransactionCanceledException tce) {
            return ResponseWrapper.ofErr(1, "id has used, please use another ID");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseWrapper.ofErr(500, e.getMessage());
        }
    }

    public ResponseWrapper addWithGeneratedId(T model) {
        model.setId(null);
        mapper.save(model);
        return ResponseWrapper.ofSuc();
    }

    public ResponseWrapper<T> get(String Id) {
        return ResponseWrapper.ofSuc(mapper.load(clazz, Id));
    }


    public ResponseWrapper delete(String Id) {

        try {
            T newModel = clazz.newInstance();
            newModel.setId(Id);
            mapper.delete(newModel);
        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseWrapper.ofErr(501, "internal error");
        }
        return ResponseWrapper.ofSuc();
    }


    // Updating Professor Info
    public ResponseWrapper update(String Id, T newModel) {
        newModel.setId(Id);

        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.PUT)
                .build();

        mapper.save(newModel, config);

        return ResponseWrapper.ofSuc();
    }


}
