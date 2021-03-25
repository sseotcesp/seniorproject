package org.senproject.ppapa.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazonaws.services.lambda.runtime.Context;

public class APIGetTest {

	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

		JSONParser parser = new JSONParser();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		JSONObject responseJson = new JSONObject();
		try {
			JSONObject responseBody = new JSONObject();
			
			//JSONObject event = (JSONObject) parser.parse(reader);
			context.getLogger().log("APITest invoked");
			JSONObject headerJson = new JSONObject();
			headerJson.put("x-custom-header", "my custom header value");

			responseJson.put("statusCode", 200);
			responseJson.put("headers", headerJson);
			responseJson.put("body", "FFFFFFFFFFFFFFFFFFFFFFFFFFFF");

		} catch (Exception pex) {
			responseJson.put("statusCode", 400);
			responseJson.put("exception", pex);
		}

		OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
		writer.write(responseJson.toString());
		writer.close();
	}

}
