package stepdefination;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import POJO.AddPlace;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {

	RequestSpecification req;
	RequestSpecification res;
	Response  response;
	ResponseSpecification resspec;
	
	TestDataBuild data = new TestDataBuild(); 
	
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
 
		
		
	resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	res = RestAssured.given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));

	}
	@When("User calls {string} with {string} HTTP request")
	public void user_calls_with_http_request(String resource, String method) {
	  
	// Constructor will be called woth the value of resource which you have pass	
		
		APIResources  resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		response = res.when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))         
		response = res.when().get(resourceAPI.getResource()); 
		
	}
	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {

	 assertEquals(response.getStatusCode(), 200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
	    String resp = response.asString();
	    JsonPath js = new JsonPath(resp);	
	    assertEquals(js.get(keyvalue).toString(), expectedvalue);
	}


	
	
}
