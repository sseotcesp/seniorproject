package org.senproject.ppapa.model;

import java.util.UUID;

public class Prescription extends JsonModel {

	private String key;
	private String information;



	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}



}
