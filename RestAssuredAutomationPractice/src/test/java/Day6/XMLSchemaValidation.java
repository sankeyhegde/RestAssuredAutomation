package Day6;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class XMLSchemaValidation {

	@Test
	
	void xmlvalidation() {
		
		given()
		.when().get("http://localhost:8080")
		.then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
		
	}
	
}
