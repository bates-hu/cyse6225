
aws dynamodb delete-table --endpoint-url http://localhost:8000 --table-name Announcement

aws dynamodb create-table --endpoint-url http://localhost:8000\
    --table-name Announcement \
    --attribute-definitions \
        AttributeName=id,AttributeType=S \
    --key-schema \
        AttributeName=id,KeyType=HASH \
    --provisioned-throughput \
        ReadCapacityUnits=1,WriteCapacityUnits=1


aws dynamodb update-table --endpoint-url http://localhost:8000\
    --table-name Announcement \
    --attribute-definitions AttributeName=boardId,AttributeType=S \
    --global-secondary-index-updates \
    "[{\"Create\":{\"IndexName\": \"boardId-index\",\"KeySchema\":[{\"AttributeName\":\"boardId\",\"KeyType\":\"HASH\"}], \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 1, \"WriteCapacityUnits\": 1 },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"

