package org.senproject.ppapa.handler;

import org.senproject.ppapa.dto.Response;
import org.senproject.ppapa.model.User;
import org.senproject.ppapa.repository.UserRepository;

import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateUserHandler implements RequestHandler<User, Response> {

	public Response handleRequest(User user, Context context) {
		context.getLogger().log("User: " + user.getUserId());
		PutItemOutcome outcome = new UserRepository().save(user);
		
		Response r = new Response();
		r.setMessage("TEST SUCCESS " + outcome.toString());
		return r;
	}

}
