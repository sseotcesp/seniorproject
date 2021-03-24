package org.senproject.ppapa.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.senproject.ppapa.model.Login;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LoginCheck implements RequestStreamHandler {

	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

		JSONParser parser = new JSONParser();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		JSONObject responseJson = new JSONObject();
		try {
			JSONObject responseBody = new JSONObject();
			JSONObject event = (JSONObject) parser.parse(reader);
			context.getLogger().log("LoginCheck invoked " + event);
			if (event.get("body") != null) {
				Login login = Login.newInstance(Login.class, (String) event.get("body"));
				if (login.check()) {
					responseBody.put("message", "Login Successful");
				} else
					responseBody.put("message", "You suck.");

			}

			JSONObject headerJson = new JSONObject();
			headerJson.put("x-custom-header", "my custom header value");

			responseJson.put("statusCode", 200);
			responseJson.put("headers", headerJson);
			responseJson.put("body", responseBody.toString());

		} catch (ParseException pex) {
			responseJson.put("statusCode", 400);
			responseJson.put("exception", pex);
		}

		OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
		writer.write(responseJson.toString());
		writer.close();
	}

	public void handleGetByParam(InputStream inputStream, OutputStream outputStream, Context context)
			throws IOException {

		// implementation
	}

	public void handleLogin(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

	}

}
