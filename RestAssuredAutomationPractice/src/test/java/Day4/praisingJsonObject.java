package Day4;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class praisingJsonObject {
	
	@Test
	void test_Jsonobject() {
		
		
		//approch 1
		
//		given()
//		.contentType("ContentType.JSON")
//		
//		.when().get("https://www.google.com/")
//		
//		
//		.then()
//		.statusCode(201)
//		.body("Book[3].title",equalTo ("xyz"));
		
//		
//		
//		//Approch 2
//		Response res=given()
//		.contentType("ContentType.JSON")
//		
//		.when().get("https://www.google.com/");
//		
//		Assert.assertEquals(res.statusCode(),200);
//		String json =res.jsonPath().get("Book[3].title").toString();
//		Assert.assertEquals(json,"xyz");
		
		Response res=given()
		.contentType("ContentType.JSON")
		
		.when().get("https://www.google.com/");
		
		//using JSON Object
		JSONObject jo = new JSONObject(res.toString());
		
//		//print all title of books
//		
//		for(int i=1;i<jo.getJSONArray("Books").length();i++) {
//			
//			String titleName = jo.getJSONArray("Books").getJSONObject(i).get("Title").toString();
//			System.out.println(titleName);
//		}
		//validation of titleName
		Boolean status = false;
		for(int i=1;i<jo.getJSONArray("Books").length();i++) {
		
		String titleName = jo.getJSONArray("Books").getJSONObject(i).get("Title").toString();
		
		if(titleName.equals("xyz"))
		{
			status =true;
		}
		
		Assert.assertEquals(status, true);
	}
		
		
		//validation of price
		Double totalprice;;
		
		for(int i=1;i<jo.getJSONArray("Books").length();i++) {
			
			String price = jo.getJSONArray("Books").getJSONObject(i).get("price").toString();
//			totalprice = totalprice+Double.parseDouble(price);
		}
		}
		

}
