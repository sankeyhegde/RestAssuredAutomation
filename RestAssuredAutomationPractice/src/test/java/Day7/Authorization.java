package Day7;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Day2.POJO_PutRequest;

public class Authorization {

	@Test
	
	void testBasicAutorization() {
		
		
		given().auth().basic(null, null)
	.when()
	.get("https://reqres.in/api/users")
			
	.then().statusCode(200)
	.body("authonicated",equalTo(true)).log().all();

		
	}
	
@Test
	
	void testDigestAutorization() {
		
		
		given().auth().basic(null, null)
	.when()
	.get("https://reqres.in/api/users")
			
	.then().statusCode(200)
	.body("authonicated",equalTo(true)).log().all();

		
	}
	
	@Test
	
	void testPremitiveAutorization() {
		
		
		given().auth().preemptive().basic(null, null)
	.when()
	.get("https://reqres.in/api/users")
			
	.then().statusCode(200)
	.body("authonicated",equalTo(true)).log().all();
	
		
	}
	
	@Test
	
	void testBarerTokenAutorization() {
		
		String token ="xyz_123";
		
		given().headers("Authorization","Bearer"+token)
	.when()
	.get("https://reqres.in/api/users")
			
	.then().statusCode(200)
	.body("authonicated",equalTo(true)).log().all();
	
		
	}
	
	@Test
	
	void testOauth1Authorization() {
		
		given().auth().oauth("cosumerkey", "consumersecrate", "accesstoken", "tokensecrate")
		.when()
		.get("xyz.com")
				
		.then().statusCode(200)
		.body("authonicated",equalTo(true)).log().all();
		
		
	}
	
	@Test
	
	void testOauth2Authorization() {
		
		given().auth().oauth2("ducsh77988e9o30")
		.when()
		.get("xyz.com")
				
		.then().statusCode(200)
		.body("authonicated",equalTo(true)).log().all();
		
		
	}
	
	@Test
	
	void testApikeyAuthorization() {
		
		given().queryParams("mypath","xyz")
		.when()
		.get("xyz.com")
				
		.then().statusCode(200)
		.body("authonicated",equalTo(true)).log().all();
	}
	
}
