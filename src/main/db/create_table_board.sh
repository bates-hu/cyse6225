
aws dynamodb delete-table --endpoint-url http://localhost:8000 --table-name Board

aws dynamodb create-table --endpoint-url http://localhost:8000\
    --table-name Board \
    --attribute-definitions \
        AttributeName=id,AttributeType=S \
    --key-schema \
        AttributeName=id,KeyType=HASH \
    --provisioned-throughput \
        ReadCapacityUnits=1,WriteCapacityUnits=1


#aws dynamodb update-table --endpoint-url http://localhost:8000\
#    --table-name Professor \
#    --attribute-definitions AttributeName=professorId,AttributeType=S \
#    --global-secondary-index-updates \
#    "[{\"Create\":{\"IndexName\": \"professorId-index\",\"KeySchema\":[{\"AttributeName\":\"professorId\",\"KeyType\":\"HASH\"}], \
#    \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 1, \"WriteCapacityUnits\": 1      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"
#
