package Day3;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQerryParameter {
	
	
	@Test
	void pathReq() {
	given()
	
	.pathParam("myPath", "users")//path parameter
	.queryParams("page", "2") //req parameter
	.queryParam("id", "10") //req parameter
	
	.when()
	.get("https://reqres.in/api/{myPath}")
			
	.then()
	.statusCode(200)
//	.body("id", equalTo("10"))
//	.body("email", equalTo("byron.fields@reqres.in"))
//	.body("first_name", equalTo("Byron"))
//	.body("last_name", equalTo("Fields"))
	
	.log().all();
}
}

