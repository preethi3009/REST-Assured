package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestExamples {
	
	@Test
	public void test_1() {
		
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		AssertJUnit.assertEquals(statusCode,200 ); 
		
	}
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api"; //you can use baseURI instead of whole URI
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",equalTo(8)). //jsonpath
			log().all();  
	}
	

}
