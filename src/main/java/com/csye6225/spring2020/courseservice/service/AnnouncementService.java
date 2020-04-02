package com.csye6225.spring2020.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.spring2020.courseservice.datamodel.Announcement;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

import java.util.HashMap;
import java.util.List;

public class AnnouncementService extends RestService<Announcement>{

    private static final int TEXT_MAX_LEN = 160;

    public AnnouncementService() {
        super(Announcement.class);
    }



    public ResponseWrapper<List<Announcement>> getAnnoucementsByBoardId(String boardId) {

        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1", new AttributeValue().withS(boardId));

        DynamoDBQueryExpression<Announcement> expression = new DynamoDBQueryExpression<Announcement>()
                .withIndexName("boardId-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("boardId = :v1")
                .withExpressionAttributeValues(eav);

        List<Announcement> ret = mapper.query(Announcement.class, expression);

        return ResponseWrapper.ofSuc(ret);
    }

    @Override
    public ResponseWrapper addWithGeneratedId(Announcement model) {
        if (model.getText() != null && model.getText().length() > TEXT_MAX_LEN) {
            return ResponseWrapper.ofErr(3, "Announcement text too long");
        }
        return super.addWithGeneratedId(model);
    }

    @Override
    public ResponseWrapper update(String Id, Announcement newModel) {
        if (newModel.getText() != null && newModel.getText().length() > TEXT_MAX_LEN) {
            return ResponseWrapper.ofErr(3, "Announcement text too long");
        }
        return super.update(Id, newModel);
    }
}
