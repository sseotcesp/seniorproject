package org.senproject.ppapa.repository;

import org.senproject.ppapa.dto.PrescriptionKey;
import org.senproject.ppapa.model.Prescription;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

public class PrescriptionRepository {

	private DynamoDB dynamoDb;
	private String DYNAMODB_TABLE_NAME = "Prescription";
	public static Regions REGION = Regions.US_EAST_1;

	public PrescriptionRepository() {
		initDynamoDbClient();
	}

	public PutItemOutcome save(Prescription prescription) throws ConditionalCheckFailedException {
		Item item = new Item();

		item.withString("key", prescription.getKey());
		item.withString("information", prescription.getInformation());
		return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME).putItem(new PutItemSpec().withItem(item));

	}

	public boolean userExists(Prescription prescription) {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(REGION));
		DynamoDB dynamoDB1 = new DynamoDB(client);
		Table table = dynamoDB1.getTable("User");
		// GetItemSpec spec = new GetItemSpec().withPrimaryKey("userId",
		// prescription.getPuser());
		Item dummy = table.getItem("userId", prescription.getKey());
		// Item dummy = table.getItem(spec);
		// spec.withProjectionExpression("role");
		if (dummy != null && dummy.getString("role").equals("PHARMACIST"))// table.getItem(spec).toString() !=
																			// "PHARMACIST")
			return true;
		else
			return false;
	}

	/*
	 * public User findByUserId(String userId) {
	 * dynamoDb.getTable(DYNAMODB_TABLE_NAME).get return null; }
	 */public String getPrescription(PrescriptionKey prescriptionKey) {
		Item dummy = this.dynamoDb.getTable(DYNAMODB_TABLE_NAME).getItem("key", prescriptionKey.getKey());
		return dummy.getString("information");

	}

	private void initDynamoDbClient() {

		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(REGION));
		this.dynamoDb = new DynamoDB(client);
	}

}
