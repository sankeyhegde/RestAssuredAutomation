package Day3;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {

	
	@Test (enabled = false)
	
	void getCookies()
	{
		
		given()
		
		.when().get("https://www.google.com/")
		
		
		.then()
		.cookie("__Host-GAPS","1%3AbRrVh66DU7viWp0nJSmjnT6OUr_oJg%3A98-1UzkZnB1tIUG8")
		.log().all();
		
	}
	
@Test (priority =2)
	
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
