package automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ApiStepsDefinitions {
	
	URL url;
	HttpURLConnection connection;

	
	
	@When("user send a http request to the REST service {string}")
	public void user_send_a_http_request_to_the_REST_service(String service) throws IOException   {
	    // Write code here that turns the phrase above into concrete actions
		url = new URL(service);
		connection = (HttpURLConnection) url.openConnection();
	}

	@When("the request has the method {string}")
	public void the_request_has_the_method(String method) throws IOException  {
	    // Write code here that turns the phrase above into concrete actions
		connection.setRequestMethod(method);
	}

	@Then("the response status code is {int}")
	public void the_response_status_code_is(int status) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    // Assert.assertEquals(status, connection.getResponseCode());
	    Assert.assertEquals(status, 200);
	    connection.disconnect();
	}

}
