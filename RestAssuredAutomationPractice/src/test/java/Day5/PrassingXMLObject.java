package Day5;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class PrassingXMLObject {
	
	//@Test
	void test_XMLobject() {
		
		//1st Approch
//		
//		given().
//		
//		when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
//		.then()
//		.statusCode(200)
//		.header("content-typpe", "application/xml : charset=utf-8")
//		.body("TravelerInformationResponse.page",equalTo(1));
		
		
		//2nd approch
		
		
		Response res=
		given().
		
		when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(res.getStatusCode(), 200);
		String page=	res.xmlPath().get("TravelerInformationResponse.page").toString();
		Assert.assertEquals(page, "1");
	}
	//@Test
	void xmlObject2() {

		Response res=
		given().
		
		when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj=new XmlPath(res.asString());
	List<String> names=	xmlobj.getList("TravelerInformationResponse.Travellers");
	Assert.assertEquals(names.size(), 10);
	}
	
	@Test
	void xmlObjectVerification() {

		Response res=
		given().
		
		when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj=new XmlPath(res.asString());
	List<String> names=	xmlobj.getList("TravelerInformationResponse.Travellers");
	Assert.assertEquals(names.size(), 10);
	
	Boolean bs = false;
	
	for(String traveller_name:names)
	{
		System.out.println(traveller_name);
		
		if(traveller_name == "xyz")
		{
			bs=true;
		}
	}
	
	Assert.assertEquals(bs, true);
	}


}
