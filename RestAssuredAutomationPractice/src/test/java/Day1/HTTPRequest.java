package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import  io.restassured.response.Response;

public class HTTPRequest {
	int id;
	
	@Test(enabled = false)
	 void getuser() {
		Response response=get("https://reqres.in/api/users/2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, "200");
	}

	@Test(enabled = false)
	void test2() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
	@Test(priority = 0)
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name", "sam");
		data.put("job","dev");
		
	id=	given()
			.contentType("Application/json")
			.body(data)
		.when()
		.post("https://reqres.in/api/users").jsonPath().getInt("id");
		
		System.out.println(id);
		
//		.then()
//		.statusCode(201).log().all();
	}
	
	@Test(priority = 1,dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "agni");
		data.put("job","test");
		
		given()
			.contentType("Application/json")
			.body(data)
		.when()
		.put("https://reqres.in/api/users"+id)	
		
		.then()
		.statusCode(200).log().all();
	}
	
	@Test(priority = 1,dependsOnMethods = {"createUser"})
	void deleteUser() {
		
		
		
		given()
			
		.when()
		.delete("https://reqres.in/api/users"+id)	
		
		.then()
		.statusCode(204).log().all();
	}
}
