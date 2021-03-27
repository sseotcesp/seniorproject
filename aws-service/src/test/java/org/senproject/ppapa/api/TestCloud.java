package org.senproject.ppapa.api;

import software.amazon.awssdk.services.cloudwatch.model.CloudWatchException;
import com.amazonaws.services.cloudwatchevents.AmazonCloudWatchEvents;
import com.amazonaws.services.cloudwatchevents.AmazonCloudWatchEventsClient;
import com.amazonaws.services.cloudwatchevents.AmazonCloudWatchEventsClientBuilder;
import com.amazonaws.services.cloudwatchevents.model.PutRuleRequest;
import com.amazonaws.services.cloudwatchevents.model.PutRuleResult;
import com.amazonaws.services.cloudwatchevents.model.RuleState;



public class TestCloud {

	public static void main(String[] args) {

//	       final String USAGE = "\n" +
//	                "Usage:\n" +
//	                "  PutRule <ruleName> roleArn> \n\n" +
//	                "Where:\n" +
//	                "  ruleName - a rule name (for example, myrule).\n" +
//	                "  roleArn - a role ARN value (for example, arn:aws:iam::xxxxxx047983:user/MyUser).\n" ;

//	        if (args.length != 2) {
//	            System.out.println(USAGE);
//	            System.exit(1);
//	        }

		String ruleName = "idk";
		String roleArn = "arn:aws:events:us-east-1:189216811643";

		AmazonCloudWatchEventsClient cwe = new AmazonCloudWatchEventsClient(); 

		putCWRule(cwe, ruleName, roleArn);
		
	}

	// snippet-start:[cloudwatch.java2.put_rule.main]
	public static void putCWRule(AmazonCloudWatchEvents cwe, String ruleName, String roleArn) {

		try {
			PutRuleRequest request = new PutRuleRequest()
					.withName(ruleName)
					.withRoleArn(roleArn)
					.withScheduleExpression("rate(5 minutes)")
					.withState(RuleState.ENABLED);

			PutRuleResult response = cwe.putRule(request);
			System.out.printf("Successfully created CloudWatch events rule %s with arn %s");
			// roleArn, response.ruleArn());
		} catch (CloudWatchException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(1);
		}
	}
}
