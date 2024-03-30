package Day2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostRequestWays {

	int id;
	
	@Test(priority = 0)
	void postUsingHasMap() {
		
		HashMap data = new HashMap();
		data.put("name", "sam");
		data.put("job","dev");
		
		given()
			.contentType("Application/json")
			.body(data)
		.when()
		.post("https://reqres.in/api/users")
				
		.then()
		.statusCode(201)
		.body("name",equalTo("sam"))
		.body("job",equalTo("dev"))
		.log().all();
	}
	
	@Test(priority=2)
	void postUsingJsonOrg() {
		
		
		JSONObject data = new JSONObject();
		data.put("name", "sam");
		data.put("job","dev");
		given()
		.contentType("Application/json")
		.body(data.toString())
	.when()
	.post("https://reqres.in/api/users")
			
	.then()
	.statusCode(201)
	.body("name",equalTo("sam"))
	.body("job",equalTo("dev"))
	.log().all();
	}
	
	@Test(priority=3)
	void postUsingPOJO() {
		
		
		POJO_PutRequest data =new POJO_PutRequest();
		data.setName("gundi");
		data.setJob("dancer");
		
		given()
		.contentType("Application/json")
		.body(data)
	.when()
	.post("https://reqres.in/api/users")
			
	.then()
	.statusCode(201)
	.body("name",equalTo("gundi"))
	.body("job",equalTo("dancer"))
	.log().all();
	}
	
	@Test(priority=4)
	void postUsingJsonExternalFile() throws FileNotFoundException {
		
		
		File fr = new File(".//JsonObj.json");
		FileReader Frd = new FileReader(fr);
		JSONTokener json = new JSONTokener(Frd);
		JSONObject data = new JSONObject(json);
		
		given()
		.contentType("Application/json")
		.body(data.toString())
	.when()
	.post("https://reqres.in/api/users")
			
	.then()
	.statusCode(201)
	.body("name",equalTo("Gunda"))
	.body("job",equalTo("driver"))
	.log().all();
	}
}
