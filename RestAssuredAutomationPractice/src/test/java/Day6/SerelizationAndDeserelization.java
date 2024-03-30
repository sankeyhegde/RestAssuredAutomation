package Day6;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Day2.POJO_PutRequest;

public class SerelizationAndDeserelization {

	
	//@Test
	
	void convertPOJOtoJSON() throws JsonProcessingException
	{
		
		//create java object using POJO class
		POJO_PutRequest data =new POJO_PutRequest();
		data.setName("gundi");
		data.setJob("dancer");
		
		//convert Pojo to JSON 
		ObjectMapper objMapper =new ObjectMapper();
		String jsonobj=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsonobj);
	}
	
	@Test
	
	void convertJSONtoPOJO() throws JsonMappingException, JsonProcessingException {
		
		String json1Obj= "{\r\n"
				+ "  \"name\" : \"gundi\",\r\n"
				+ "  \"job\" : \"dancer\"\r\n"
				+ "}";
		
		ObjectMapper objMapper =new ObjectMapper();
		student stde1=objMapper.readValue(json1Obj, student.class);
		System.out.println(stde1);
	}
}
