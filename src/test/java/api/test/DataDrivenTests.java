package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;


import api.payload.stoDetails;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	@Test(priority=1, dataProvider="data",dataProviderClass=DataProviders.class)  // data provider class parameter only needed when data provider present in another class
	public void testPostUser(String userID,String userName,String fname	,String lname,String useremail,String password,String ph) 
	{
		 stoDetails userPayload=new stoDetails();
		 
		 userPayload.setStoNos(new String[] {"NWB24027"});
		 
		
		 
		 
	}
	
	

}
