package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class JAVAFaker {

	@Test
	
	void javafakervalidation(){
		
		Faker fake = new Faker();
		String funny = fake.name().fullName();
		System.out.println(funny);
		
	}
}
