package Day6;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class JSONSchemaValidation {

	@Test
	void JSONValidation() {
		
		given()
		
		.when().get("http://localhost:8000").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("student.json"));
		
	}
}
