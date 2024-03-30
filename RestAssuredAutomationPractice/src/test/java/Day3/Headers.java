package Day3;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class Headers {

	
	@Test (enabled = true)
	
	void getCookies()
	{
		
		given()
		
		.when().get("https://www.google.com/")
		
		
		.then()
		.header("Content-Type", "text/html; charset=utf-8");
		
	}
	
@Test (enabled = false)
	
	void getSingleCookies()
	{
		
	Response res=	given()
		
		.when().get("https://www.google.com/");
	
	
//	String COOKIE=res.getCookie("__Host-GAPS");
//	System.out.println("value of cookei  "+COOKIE);
	
	Map<String,String>	Cookies_Value=res.getCookies();
	System.out.println(Cookies_Value.keySet());
	
	for(String k:Cookies_Value.keySet())
	{
		String cookiesValue =res.getCookie(k);
		System.out.println("cookie value  "+cookiesValue);
	}
	
		
		
		
		
	}
	
	
	
}
