package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;

import api.payload.stoDetails;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	stoDetails userPayload;  
	@BeforeClass
	public void setupData()
	{
	faker = new Faker();
	userPayload = new stoDetails();
	
	userPayload.setStoNos(new String[] {"NWB24027"});
	
	}
	
	@Test(priority=1)
	public void stoDetailsingleorder() {
		Response response = UserEndPoints.fetchstodetails(userPayload);
				response.then().log().all();
		
				
				assertEquals(response.getStatusCode(),200);
	}
	
	
	

};
