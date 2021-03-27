package org.senproject.ppapa.model;

import com.amazonaws.auth.Presigner;

public class TestPrescriptionJson {

	public static void main(String[] a) {
		String json = "{\"key\": \"asdfasd\", \"puser\":\"gar\",\"information\":\"asdfasdf\" }";
		Prescription p = (Prescription) Prescription.newInstance(Prescription.class, json);
		System.out.println(p);
	}
}
