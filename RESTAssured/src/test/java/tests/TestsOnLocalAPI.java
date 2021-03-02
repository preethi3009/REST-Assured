package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestsOnLocalAPI {
	
	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		
	//	given().get("/users").then().statusCode(200).log().all();
		given().
			params("name","Automation"). //http://localhost:3000/subjects?name=Automation
			get("/subjects").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void post() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Veronica");
		request.put("lastName", "Lodge");
		request.put("subjectId", 2);
		
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
	
	//@Test
	public void put() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Kendall");
		request.put("lastName", "Jenner");
		request.put("subjectId", 1);
				
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().	
			put("/users/4").
		then(). 
			statusCode(200). 
			log().all();
		
	}
	
	//@Test
	public void patch() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("subjectId", 1);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().	
			patch("/users/4").
		then(). 
			statusCode(200). 
			log().all();
		
	}

	//@Test
	public void delete() {
		
		baseURI = "http://localhost:3000";
		
		when().	
			delete("/users/4").
		then(). 
			statusCode(200). 
			log().all();
		
	}

}
