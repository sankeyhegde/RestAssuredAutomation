package Day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;


public class FileUploadFileDownload {
	
	@Test
	void singlefFileUpload() {
		
		File myfile = new File("./myfiles/text1.txt");
		given()
		.multiPart("file","myfile")
		.contentType("multipart/form-data")
		
		.when().post("http://localhost:8080/upload file").then()
		.statusCode(200).body("myfile", equalTo("text1.txt"));
		
		
	}
	
	@Test
	void doubleFileUpload() {
		
		File myfile1 = new File("./myfiles/text1.txt");
		File myfile2 = new File("./myfiles/text2.txt");
		
		given()
		.multiPart("files",myfile1)
		.multiPart("files",myfile2)
		.contentType("multipart/form-data")
		
		.when().post("http://localhost:8080/upload files").then()
		.statusCode(200).body("[0].myfile", equalTo("text1.txt"))
		.body("[1].myfile", equalTo("text2.txt"));
		
		
	}

	
	@Test
	
	void filedownload() {
		
		given()
		
		.when().get("http://localhost:8080/download File/text1.txt")
		.then().statusCode(200).log().body();
	}
}
