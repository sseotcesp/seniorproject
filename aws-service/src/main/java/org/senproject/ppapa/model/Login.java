package org.senproject.ppapa.model;

import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.senproject.ppapa.repository.PrescriptionRepository;


public class Login extends JsonModel {

	private String user;
	private String pass;

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public boolean check() {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(PrescriptionRepository.REGION));
		DynamoDB dynamoDB1 = new DynamoDB(client); 
		Table table = dynamoDB1.getTable("User"); 
		Item dummy = table.getItem("userId", this.user); 
		if(dummy != null && dummy.getString("password").equals(this.pass))
			return true; 
		else 
			return false;
	}
}
