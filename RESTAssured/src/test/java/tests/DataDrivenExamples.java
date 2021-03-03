package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends TestData{
		
	//@Test(dataProvider = "DataForPost")
	public void post(String firstName, String lastName, int subjectId) {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().	
			post("/users").
		then(). 
			statusCode(201). 
			log().all();	
	}
	
	//@Test(dataProvider = "DataForDelete")
	public void delete(int userId) {
		
		baseURI = "http://localhost:3000";
		
		when().	
			delete("/users/" + userId).
		then(). 
			statusCode(200). 
			log().all();
		
	}
	
	@Parameters({"userId"})
	@Test
	public void deleteParametersExample(int userId) {
		
		System.out.println(userId);
		
		baseURI = "http://localhost:3000";
		
		when().	
			delete("/users/" + userId).
		then(). 
			statusCode(200). 
			log().all();
		
	}

}
