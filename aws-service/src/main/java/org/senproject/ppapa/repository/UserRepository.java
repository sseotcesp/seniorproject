package org.senproject.ppapa.repository;

import org.senproject.ppapa.model.User;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

public class UserRepository {

	private DynamoDB dynamoDb;
	private String DYNAMODB_TABLE_NAME = "User";
	private Regions REGION = Regions.US_EAST_1;

	public UserRepository() {
		initDynamoDbClient();
	}

	public PutItemOutcome save(User user) throws ConditionalCheckFailedException {
		Item item = new Item();
		item.withString("userId", user.getUserId());
		item.withString("password", user.getPassword());
		item.withString("role", user.getRole().name());
		return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME).putItem(new PutItemSpec().withItem(item));
	}

	private void initDynamoDbClient() {

		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(REGION));
		this.dynamoDb = new DynamoDB(client);
	}
}
